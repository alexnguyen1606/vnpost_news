package com.vnpost.converter;

import com.vnpost.dto.MainCategoryDTO;
import com.vnpost.entity.MainCategoryEntity;
import com.vnpost.utils.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainCategoryConverter implements IDTO<MainCategoryDTO>,IEntity<MainCategoryEntity>{
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public MainCategoryDTO convertToDTO(Object object) {
        MainCategoryEntity entity = (MainCategoryEntity) object;
        MainCategoryDTO dto = modelMapper.map(entity,MainCategoryDTO.class);
        return dto;
    }

    @Override
    public MainCategoryEntity convertToEntity(Object object) {
        MainCategoryDTO dto = (MainCategoryDTO) object;
        MainCategoryEntity entity = modelMapper.map(dto,MainCategoryEntity.class);
        entity.setUrl(StringUtils.convert(dto.getName()));
        return entity;
    }
}
