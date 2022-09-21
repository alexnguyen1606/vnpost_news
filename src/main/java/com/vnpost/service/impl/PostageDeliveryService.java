package com.vnpost.service.impl;

import com.vnpost.converter.PostageDeliveryConverter;
import com.vnpost.dto.PostageDeliveryDTO;
import com.vnpost.repository.entity.PostageDeliveryEntity;
import com.vnpost.repository.PostageDeliveryRepository;
import com.vnpost.service.IPostageDeliveryService;
import com.vnpost.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostageDeliveryService implements IPostageDeliveryService {
    @Autowired
    private PostageDeliveryConverter converter;
    @Autowired
    private PostageDeliveryRepository postageDeliveryRepository;
    @Autowired
    private FileUtils fileUtils;
    @Override
    public List<PostageDeliveryDTO> findAll() {
        return postageDeliveryRepository.findAll()
                .stream().map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public PostageDeliveryDTO save(PostageDeliveryDTO postageDeliveryDTO) {
        Long id = postageDeliveryDTO.getId();
        if (id==null){
            String image = fileUtils.SaveFile(postageDeliveryDTO.getMultipartFile());
            if (!image.equals("")){
                postageDeliveryDTO.setImage(image);
            }
            PostageDeliveryEntity entity = converter.convertToEntity(postageDeliveryDTO);
            return converter.convertToDTO(postageDeliveryRepository.save(entity));
        }
        return new PostageDeliveryDTO();
    }

    @Override
    public PostageDeliveryDTO update(PostageDeliveryDTO postageDeliveryDTO) {
        Long id = postageDeliveryDTO.getId();
        if (id!=null){
            PostageDeliveryEntity entity = converter.convertToEntity(postageDeliveryDTO);
            PostageDeliveryEntity entityInDb = postageDeliveryRepository.findById(id).get();
            String image = fileUtils.SaveFile(postageDeliveryDTO.getMultipartFile());
            if (!image.equals("")){
                entity.setImage(image);
            }else {
                entity.setImage(entityInDb.getImage());
            }
            entity.setCreatedBy(entityInDb.getCreatedBy());
            entity.setCreatedDate(entityInDb.getCreatedDate());
            return converter.convertToDTO(postageDeliveryRepository.save(entity));
        }
        return new PostageDeliveryDTO();
    }

    @Override
    public void deleteOne(Long id) {
        if (postageDeliveryRepository.existsById(id)){
            postageDeliveryRepository.deleteById(id);
        }
    }
}
