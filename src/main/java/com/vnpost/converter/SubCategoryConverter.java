package com.vnpost.converter;

import com.vnpost.dto.SubCategoryDTO;
import com.vnpost.entity.SubCategoryEntity;
import com.vnpost.utils.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryConverter implements IDTO<SubCategoryDTO>,IEntity<SubCategoryEntity>{
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public SubCategoryDTO convertToDTO(Object object) {
        SubCategoryEntity entity = (SubCategoryEntity) object;
        SubCategoryDTO dto = modelMapper.map(entity,SubCategoryDTO.class);
        return dto;
    }

    @Override
    public SubCategoryEntity convertToEntity(Object object) {
        SubCategoryDTO dto = (SubCategoryDTO) object;
        SubCategoryEntity entity = modelMapper.map(dto,SubCategoryEntity.class);
        entity.setUrl(StringUtils.convert(dto.getName()));
        return entity;
    }
}
