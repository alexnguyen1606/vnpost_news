package com.vnpost.converter;

import com.vnpost.dto.RoleDTO;
import com.vnpost.entity.RoleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements IDTO<RoleDTO>,IEntity<RoleEntity>{
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public RoleDTO convertToDTO(Object object) {
        RoleEntity entity = (RoleEntity) object;
        RoleDTO dto = modelMapper.map(entity,RoleDTO.class);
        return dto;
    }

    @Override
    public RoleEntity convertToEntity(Object object) {
        RoleDTO dto = (RoleDTO) object;
        RoleEntity entity = modelMapper.map(dto,RoleEntity.class);
        return entity;
    }
}
