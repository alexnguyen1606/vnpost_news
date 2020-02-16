package com.vnpost.converter;

import com.vnpost.dto.ParagraphDTO;
import com.vnpost.entity.ParagraphEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParagraphConverter implements IDTO<ParagraphDTO>,IEntity<ParagraphEntity>{
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ParagraphDTO convertToDTO(Object object) {
        ParagraphEntity entity = (ParagraphEntity) object;
        ParagraphDTO dto = modelMapper.map(entity,ParagraphDTO.class);
        return dto;
    }

    @Override
    public ParagraphEntity convertToEntity(Object object) {
        ParagraphDTO dto = (ParagraphDTO) object;
        ParagraphEntity entity = modelMapper.map(dto,ParagraphEntity.class);
        return entity;
    }
}
