package com.vnpost.service.impl;

import com.vnpost.converter.PostageFinaceConverter;
import com.vnpost.dto.PostageFinaceDTO;
import com.vnpost.repository.entity.PostageFinaceEntity;
import com.vnpost.repository.PostageFinaceRepository;
import com.vnpost.service.IPostageFinaceService;
import com.vnpost.utils.FileUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class PostageFinaceService implements IPostageFinaceService {
    private PostageFinaceConverter converter;
    private PostageFinaceRepository postageFinaceRepository;
    private FileUtils fileUtils;

    @Override
    public List<PostageFinaceDTO> findAll() {
        return postageFinaceRepository.findAll()
                .stream().map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostageFinaceDTO> findAll(Pageable pageable) {
        return postageFinaceRepository.findAll(pageable)
                .map(converter::convertToDTO)
                .toList();
    }

    @Override
    public PostageFinaceDTO findById(Long id) {
        return converter.convertToDTO(postageFinaceRepository.findById(id).get());
    }

    @Override
    public PostageFinaceDTO save(PostageFinaceDTO postageFinaceDTO) {
        String image = fileUtils.SaveFile(postageFinaceDTO.getMultipartFile());
        if (!image.equals("")) {
            postageFinaceDTO.setImage(image);
        }
        PostageFinaceEntity entity = converter.convertToEntity(postageFinaceDTO);
        return converter.convertToDTO(postageFinaceRepository.save(entity));
    }

    @Override
    public PostageFinaceDTO update(PostageFinaceDTO postageFinaceDTO) {
        Long id = postageFinaceDTO.getId();
        PostageFinaceEntity entity = converter.convertToEntity(postageFinaceDTO);
        PostageFinaceEntity entityInDb = postageFinaceRepository.findById(id).get();
        String image = fileUtils.SaveFile(postageFinaceDTO.getMultipartFile());
        if (!image.equals("")) {
            entity.setImage(image);
        } else {
            entity.setImage(entityInDb.getImage());
        }
        entity.setCreatedBy(entityInDb.getCreatedBy());
        entity.setCreatedDate(entityInDb.getCreatedDate());
        return converter.convertToDTO(postageFinaceRepository.save(entity));
    }

    @Override
    public void deleteOne(Long id) {

    }

    @Override
    public Integer count() {
        return Math.toIntExact(postageFinaceRepository.count());
    }
}
