package com.vnpost.converter;

import com.vnpost.dto.PostageDeliveryDTO;
import com.vnpost.repository.entity.PostageDeliveryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostageDeliveryConverter implements IConverter<PostageDeliveryDTO, PostageDeliveryEntity> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostageDeliveryDTO convertToDTO(PostageDeliveryEntity object) {
        return modelMapper.map(object, PostageDeliveryDTO.class);
    }

    @Override
    public PostageDeliveryEntity convertToEntity(PostageDeliveryDTO object) {
        return modelMapper.map(object, PostageDeliveryEntity.class);
    }
}
