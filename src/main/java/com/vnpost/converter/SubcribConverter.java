package com.vnpost.converter;

import com.vnpost.dto.SubcribDTO;
import com.vnpost.entity.SubcribEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubcribConverter implements IDTO<SubcribDTO>,IEntity<SubcribEntity> {
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public SubcribDTO convertToDTO(Object object) {
        SubcribEntity entity = (SubcribEntity) object;
        SubcribDTO dto = modelMapper.map(entity,SubcribDTO.class);
        return dto;
    }

    @Override
    public SubcribEntity convertToEntity(Object object) {
        SubcribDTO dto = (SubcribDTO) object;
        SubcribEntity entity = modelMapper.map(dto,SubcribEntity.class);
        return entity;
    }
}
