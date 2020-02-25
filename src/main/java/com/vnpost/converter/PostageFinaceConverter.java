package com.vnpost.converter;

import com.vnpost.dto.PostageDeliveryDTO;
import com.vnpost.dto.PostageFinaceDTO;
import com.vnpost.entity.PostageDeliveryEntity;
import com.vnpost.entity.PostageFinaceEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostageFinaceConverter implements IDTO<PostageFinaceDTO>,IEntity<PostageFinaceEntity> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostageFinaceDTO convertToDTO(Object object) {
        PostageFinaceEntity entity = (PostageFinaceEntity) object;
        PostageFinaceDTO dto = modelMapper.map(entity,PostageFinaceDTO.class);
        return dto;
    }

    @Override
    public PostageFinaceEntity convertToEntity(Object object) {
        PostageFinaceDTO dto = (PostageFinaceDTO) object;
        PostageFinaceEntity entity = modelMapper.map(dto,PostageFinaceEntity.class);
        return entity;
    }
}
