package com.vnpost.converter;

import com.vnpost.dto.CategoryDTO;
import com.vnpost.repository.entity.CategoryEntity;
import com.vnpost.utils.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    @Autowired
    private ModelMapper modelMapper;
    public CategoryDTO convertToDTO(CategoryEntity entity) {
        CategoryDTO dto = modelMapper.map(entity, CategoryDTO.class);
        return dto;
    }


    public CategoryEntity convertToEntity(CategoryDTO dto) {
        CategoryEntity entity = modelMapper.map(dto, CategoryEntity.class);
        entity.setUrl(StringUtils.convert(dto.getName()));
        return entity;
    }
}
