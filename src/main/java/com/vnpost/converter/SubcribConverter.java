package com.vnpost.converter;

import com.vnpost.dto.SubcribDTO;
import com.vnpost.repository.entity.SubcribEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubcribConverter implements IConverter<SubcribDTO, SubcribEntity> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SubcribDTO convertToDTO(SubcribEntity object) {
        return modelMapper.map(object, SubcribDTO.class);
    }

    @Override
    public SubcribEntity convertToEntity(SubcribDTO object) {
        return modelMapper.map(object, SubcribEntity.class);
    }
}
