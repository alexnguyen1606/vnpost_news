package com.vnpost.converter;

import com.vnpost.dto.PostageFinaceDTO;
import com.vnpost.repository.entity.PostageFinaceEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostageFinaceConverter implements IConverter<PostageFinaceDTO, PostageFinaceEntity> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostageFinaceDTO convertToDTO(PostageFinaceEntity object) {
        return modelMapper.map(object,PostageFinaceDTO.class);
    }

    @Override
    public PostageFinaceEntity convertToEntity(PostageFinaceDTO object) {
        return modelMapper.map(object,PostageFinaceEntity.class);
    }
}
