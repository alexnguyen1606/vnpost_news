package com.vnpost.converter;

import com.vnpost.dto.UserDTO;
import com.vnpost.repository.entity.UserEntity;
import com.vnpost.utils.EncrytedPasswordUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements IConverter<UserDTO, UserEntity> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO convertToDTO(UserEntity object) {
        return modelMapper.map(object,UserDTO.class);
    }

    @Override
    public UserEntity convertToEntity(UserDTO object) {
        UserEntity entity = modelMapper.map(object, UserEntity.class);
        entity.setPassword(EncrytedPasswordUtils.encrytePassword(object.getPassword()));
        return entity;
    }
}
