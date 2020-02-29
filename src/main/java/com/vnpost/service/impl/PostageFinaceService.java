package com.vnpost.service.impl;

import com.vnpost.converter.PostageFinaceConverter;
import com.vnpost.dto.PostageFinaceDTO;
import com.vnpost.entity.PostageFinaceEntity;
import com.vnpost.repository.PostageFinaceRepository;
import com.vnpost.service.IPostageFinaceService;
import com.vnpost.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostageFinaceService implements IPostageFinaceService {
    @Autowired
    private PostageFinaceConverter converter;
    @Autowired
    private PostageFinaceRepository postageFinaceRepository;
    @Autowired
    private FileUtils fileUtils;
    @Override
    public List<PostageFinaceDTO> findAll() {
        return postageFinaceRepository.findAll()
                .stream().map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<PostageFinaceDTO> findAll(Pageable pageable) {
        return postageFinaceRepository.findAll(pageable)
                .stream().map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public PostageFinaceDTO findById(Long id) {
        if (id==null){
            return converter.convertToDTO(postageFinaceRepository.findById(id).get());
        }
        return new PostageFinaceDTO();
    }

    @Override
    public PostageFinaceDTO save(PostageFinaceDTO postageFinaceDTO) {
        Long id = postageFinaceDTO.getId();
        if (id==null){
            String image = fileUtils.SaveFile(postageFinaceDTO.getMultipartFile());
            if (!image.equals("")){
                postageFinaceDTO.setImage(image);
            }
            PostageFinaceEntity entity = converter.convertToEntity(postageFinaceDTO);
            return converter.convertToDTO(postageFinaceRepository.save(entity));
        }
        return new PostageFinaceDTO();
    }

    @Override
    public PostageFinaceDTO update(PostageFinaceDTO postageFinaceDTO) {
        Long id = postageFinaceDTO.getId();
        if (id!=null){
            PostageFinaceEntity entity = converter.convertToEntity(postageFinaceDTO);
            PostageFinaceEntity entityInDb = postageFinaceRepository.findById(id).get();
            String image = fileUtils.SaveFile(postageFinaceDTO.getMultipartFile());
            if (!image.equals("")){
                entity.setImage(image);
            }else {
                entity.setImage(entityInDb.getImage());
            }
            entity.setCreatedBy(entityInDb.getCreatedBy());
            entity.setCreatedDate(entityInDb.getCreatedDate());
            return converter.convertToDTO(postageFinaceRepository.save(entity));
        }
        return new PostageFinaceDTO();
    }

    @Override
    public void deleteOne(Long id) {

    }

    @Override
    public Integer count() {
        return Math.toIntExact(postageFinaceRepository.count());
    }
}
