package com.vnpost.converter;

import com.vnpost.dto.UserDTO;
import com.vnpost.entity.UserEntity;
import com.vnpost.utils.EncrytedPasswordUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.stream.Collectors;

@Component
public class UserConverter implements IDTO<UserDTO>,IEntity<UserEntity>{
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO convertToDTO(Object object) {
        UserEntity entity = (UserEntity) object;
        UserDTO dto = modelMapper.map(entity,UserDTO.class);
       // dto.getRoles().stream().map(item -> dto.getListRole().add(item.getCode())).collect(Collectors.toList());
        return dto;
    }

    @Override
    public UserEntity convertToEntity(Object object) {
        UserDTO dto = (UserDTO) object;
        UserEntity entity = modelMapper.map(dto, UserEntity.class);
        entity.setPassword(EncrytedPasswordUtils.encrytePassword(dto.getPassword()));
        return entity;
    }
}
