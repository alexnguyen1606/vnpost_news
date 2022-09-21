package com.vnpost.converter;

import com.vnpost.dto.MediaDistributionDTO;
import com.vnpost.repository.entity.MediaDistributionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MediaDistributionConverter implements IConverter<MediaDistributionDTO, MediaDistributionEntity> {
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public MediaDistributionDTO convertToDTO(MediaDistributionEntity object) {
        return modelMapper.map(object,MediaDistributionDTO.class);
    }

    @Override
    public MediaDistributionEntity convertToEntity(MediaDistributionDTO object) {
        return modelMapper.map(object,MediaDistributionEntity.class);
    }
}
