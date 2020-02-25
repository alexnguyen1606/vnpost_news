package com.vnpost.converter;

import com.vnpost.dto.PostageDeliveryDTO;
import com.vnpost.entity.PostageDeliveryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostageDeliveryConverter implements IDTO<PostageDeliveryDTO>,IEntity<PostageDeliveryEntity> {
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public PostageDeliveryDTO convertToDTO(Object object) {
        PostageDeliveryEntity entity = (PostageDeliveryEntity) object;
        PostageDeliveryDTO deliveryDTO = modelMapper.map(entity,PostageDeliveryDTO.class);
        return deliveryDTO;
    }

    @Override
    public PostageDeliveryEntity convertToEntity(Object object) {
        PostageDeliveryDTO dto = (PostageDeliveryDTO) object;
        PostageDeliveryEntity entity = modelMapper.map(dto,PostageDeliveryEntity.class);
        return entity;
    }
}
