package com.vnpost.converter;

import com.vnpost.dto.RoleDTO;
import com.vnpost.repository.entity.RoleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements IConverter<RoleDTO, RoleEntity> {
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public RoleDTO convertToDTO(RoleEntity object) {
        return modelMapper.map(object,RoleDTO.class);
    }

    @Override
    public RoleEntity convertToEntity(RoleDTO dto) {
        return modelMapper.map(dto,RoleEntity.class);
    }
}
