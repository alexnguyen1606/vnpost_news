package com.vnpost.converter;

import com.vnpost.dto.DeliveryServiceDTO;
import com.vnpost.repository.entity.DeliveryServiceEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryServiceConverter implements IConverter<DeliveryServiceDTO, DeliveryServiceEntity> {
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public DeliveryServiceDTO convertToDTO(DeliveryServiceEntity object) {
        return modelMapper.map(object,DeliveryServiceDTO.class);
    }

    @Override
    public DeliveryServiceEntity convertToEntity(DeliveryServiceDTO object) {
        return modelMapper.map(object, DeliveryServiceEntity.class);
    }
}
