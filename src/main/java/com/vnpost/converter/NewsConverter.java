package com.vnpost.converter;

import com.vnpost.dto.NewsDTO;
import com.vnpost.entity.NewsEntity;
import com.vnpost.utils.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewsConverter  implements IEntity<NewsEntity>, IDTO<NewsDTO> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public NewsDTO convertToDTO(Object object) {
        NewsEntity entity = (NewsEntity) object;
        NewsDTO dto = modelMapper.map(entity,NewsDTO.class);
        return dto;
    }

    @Override
    public NewsEntity convertToEntity(Object object) {
        NewsDTO dto = (NewsDTO) object;
        NewsEntity entity = modelMapper.map(dto,NewsEntity.class);
        entity.setUrl(StringUtils.convert(dto.getName()));
        return entity;
    }
}
