package com.vnpost.converter;

import com.vnpost.dto.CategoryDTO;
import com.vnpost.entity.CategoryEntity;
import com.vnpost.utils.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements IDTO<CategoryDTO>,IEntity<CategoryEntity>{
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDTO convertToDTO(Object object) {
        CategoryEntity entity = (CategoryEntity) object;
        CategoryDTO dto = modelMapper.map(entity, CategoryDTO.class);
        return dto;
    }

    @Override
    public CategoryEntity convertToEntity(Object object) {
        CategoryDTO dto = (CategoryDTO) object;
        CategoryEntity entity = modelMapper.map(dto, CategoryEntity.class);
        entity.setUrl(StringUtils.convert(dto.getName()));
        return entity;
    }
}
