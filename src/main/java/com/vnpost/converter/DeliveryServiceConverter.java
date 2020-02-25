package com.vnpost.converter;

import com.vnpost.dto.DeliveryServiceDTO;
import com.vnpost.entity.DeliveryServiceEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryServiceConverter implements IDTO<DeliveryServiceDTO>,IEntity<DeliveryServiceEntity> {
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public DeliveryServiceDTO convertToDTO(Object object) {
        DeliveryServiceEntity entity = (DeliveryServiceEntity) object;
        DeliveryServiceDTO dto = modelMapper.map(entity,DeliveryServiceDTO.class);
        return dto;
    }

    @Override
    public DeliveryServiceEntity convertToEntity(Object object) {
        DeliveryServiceDTO dto = (DeliveryServiceDTO) object;
        DeliveryServiceEntity entity = modelMapper.map(dto,DeliveryServiceEntity.class);
        return entity;
    }
}
