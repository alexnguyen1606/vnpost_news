package com.vnpost.service.impl;

import com.vnpost.constant.SystemConstant;
import com.vnpost.converter.MediaDistributionConverter;
import com.vnpost.dto.MediaDistributionDTO;
import com.vnpost.entity.MediaDistributionEntity;
import com.vnpost.repository.MediaDistributionRepository;
import com.vnpost.service.IMediaDistributionService;
import com.vnpost.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MediaDistributionService implements IMediaDistributionService {
    @Autowired
    private MediaDistributionConverter converter;
    @Autowired
    private MediaDistributionRepository distributionRepository;
    @Autowired
    private  FileUtils fileUtils;
    @Override
    public List<MediaDistributionDTO> findAll() {
        return distributionRepository.findAll().stream()
                .map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<MediaDistributionDTO> findAll(Pageable pageable) {
        return distributionRepository.findAll(pageable).stream()
                .map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public MediaDistributionDTO findById(Long id) {
        if (id!=null){
            return converter.convertToDTO(distributionRepository.findById(id));
        }
        return new MediaDistributionDTO();
    }

    @Override
    public MediaDistributionDTO save(MediaDistributionDTO mediaDistributionDTO) {
        Long id = mediaDistributionDTO.getId();
        if (id==null){
            String image = fileUtils.SaveFile(mediaDistributionDTO.getMultipartFile());
            if (!image.equals("")){
                mediaDistributionDTO.setImage(image);
            }else {
                mediaDistributionDTO.setImage(SystemConstant.THUMBNAIL_PATH);
            }
            MediaDistributionEntity entity = converter.convertToEntity(mediaDistributionDTO);
            return converter.convertToDTO(distributionRepository.save(entity));
        }
        return new MediaDistributionDTO();
    }

    @Override
    public MediaDistributionDTO update(MediaDistributionDTO mediaDistributionDTO) {
        Long id = mediaDistributionDTO.getId();
        if (id!=null){
            MediaDistributionEntity entity = converter.convertToEntity(mediaDistributionDTO);
            MediaDistributionEntity entityInDb = distributionRepository.findById(id).get();
            String image = fileUtils.SaveFile(mediaDistributionDTO.getMultipartFile());
            if (!image.equals("")){
                entity.setImage(image);
            }else {
                entity.setImage(entityInDb.getImage());
            }
            entity.setCreatedBy(entityInDb.getCreatedBy());
            entity.setCreatedDate(entityInDb.getCreatedDate());
            return converter.convertToDTO(distributionRepository.save(entity));
        }
        return new MediaDistributionDTO();
    }

    @Override
    public void deleteOne(Long id) {
        if (distributionRepository.existsById(id)){
            distributionRepository.deleteById(id);
        }
    }

    @Override
    public Integer count() {
        return Math.toIntExact(distributionRepository.count());
    }
}
