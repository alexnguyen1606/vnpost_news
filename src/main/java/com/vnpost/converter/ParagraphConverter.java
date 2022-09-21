package com.vnpost.converter;

import com.vnpost.dto.ParagraphDTO;
import com.vnpost.repository.entity.ParagraphEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParagraphConverter implements IConverter<ParagraphDTO, ParagraphEntity> {
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ParagraphDTO convertToDTO(ParagraphEntity object) {
        return modelMapper.map(object, ParagraphDTO.class);
    }

    @Override
    public ParagraphEntity convertToEntity(ParagraphDTO object) {
        return modelMapper.map(object, ParagraphEntity.class);
    }
}
