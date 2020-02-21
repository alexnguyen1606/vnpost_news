package com.vnpost.converter;

import com.vnpost.dto.CategoryDTO;
import com.vnpost.dto.NewsDTO;
import com.vnpost.entity.NewsEntity;
import com.vnpost.service.impl.CategoryService;
import com.vnpost.utils.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewsConverter   {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryService categoryService;
    public NewsDTO convertToDTO(NewsEntity object) {
        NewsEntity entity =  object;
        NewsDTO dto = modelMapper.map(entity,NewsDTO.class);
     //   dto.setParagraph1(dto.getListParagraph().get(0));
     //   dto.setParagraph2(dto.getListParagraph().get(2));
      //  dto.setParagraph3(dto.getListParagraph().get(3));
        return dto;
    }


    public NewsEntity convertToEntity(NewsDTO object) {
        NewsDTO dto = (NewsDTO) object;
        NewsEntity entity = modelMapper.map(dto,NewsEntity.class);
        entity.setUrl(StringUtils.convert(dto.getName()));
        return entity;
    }
}
