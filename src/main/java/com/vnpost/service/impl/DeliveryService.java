package com.vnpost.service.impl;

import com.vnpost.converter.DeliveryServiceConverter;
import com.vnpost.dto.DeliveryServiceDTO;
import com.vnpost.entity.DeliveryServiceEntity;
import com.vnpost.repository.DeliveryServiceRepository;
import com.vnpost.service.IDeliveryService;
import com.vnpost.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryService implements IDeliveryService {
    @Autowired
    private DeliveryServiceRepository deliveryServiceRepository;
    @Autowired
    private DeliveryServiceConverter converter;
    @Autowired
    private FileUtils fileUtils;
    @Override
    public List<DeliveryServiceDTO> findByPostageDeliveryId(Long id) {
        return deliveryServiceRepository.findByPostageDeliveryId(id)
                .stream().map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<DeliveryServiceDTO> findByPostageDeliveryId(Long id, Pageable pageable) {
        return deliveryServiceRepository.findByPostageDeliveryId(id,pageable)
                .stream().map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public DeliveryServiceDTO findById(Long id) {
        return converter.convertToDTO(deliveryServiceRepository.findById(id).get());
    }

    @Override
    public DeliveryServiceDTO save(DeliveryServiceDTO deliveryServiceDTO) {
        if (deliveryServiceDTO.getId()==null){
            String image=fileUtils.SaveFile(deliveryServiceDTO.getMultipartFile());
            if (!image.equals("")){
                deliveryServiceDTO.setImage(image);
            }
            DeliveryServiceEntity entity = converter.convertToEntity(deliveryServiceDTO);
           return converter.convertToDTO(deliveryServiceRepository.save(entity));
        }
        return new DeliveryServiceDTO();
    }

    @Override
    public DeliveryServiceDTO update(DeliveryServiceDTO deliveryServiceDTO) {
        if (deliveryServiceDTO.getId()!=null){
            DeliveryServiceEntity entity = converter.convertToEntity(deliveryServiceDTO);
            DeliveryServiceEntity entityInDb = deliveryServiceRepository.findById(deliveryServiceDTO.getId()).get();
            String image=fileUtils.SaveFile(deliveryServiceDTO.getMultipartFile());
            if (!image.equals("")){
                entity.setImage(image);
            }else {
                entity.setImage(entityInDb.getImage());
            }
            entity.setCreatedDate(entityInDb.getCreatedDate());
            entity.setCreatedBy(entityInDb.getCreatedBy());
            return converter.convertToDTO(deliveryServiceRepository.save(entity));
        }
        return new DeliveryServiceDTO();
    }

    @Override
    public void deleteOne(Long id) {
        if (deliveryServiceRepository.existsById(id)){
            deliveryServiceRepository.deleteById(id);
        }
    }

    @Override
    public List<DeliveryServiceDTO> findAll(Pageable pageable) {
        return deliveryServiceRepository.findAll(pageable)
                .stream().map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public Long count() {
        return deliveryServiceRepository.count();
    }

    @Override
    public Integer countByPostId(Long id) {
        return Math.toIntExact(deliveryServiceRepository.countDeliveryServiceEntitiesByPostageDeliveryId(id));
    }

}
