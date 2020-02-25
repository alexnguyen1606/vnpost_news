package com.vnpost.converter;

import com.vnpost.dto.MediaDistributionDTO;
import com.vnpost.entity.MediaDistributionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MediaDistributionConverter implements IDTO<MediaDistributionDTO>,IEntity<MediaDistributionEntity> {
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public MediaDistributionDTO convertToDTO(Object object) {
        MediaDistributionEntity entity = (MediaDistributionEntity) object;
        MediaDistributionDTO dto = modelMapper.map(entity,MediaDistributionDTO.class);
        return dto;
    }

    @Override
    public MediaDistributionEntity convertToEntity(Object object) {
        MediaDistributionDTO dto = (MediaDistributionDTO) object;
        MediaDistributionEntity entity = modelMapper.map(dto,MediaDistributionEntity.class);
        return entity;
    }
}
