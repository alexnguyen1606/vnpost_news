package com.vnpost.service;

import com.vnpost.dto.PostageFinaceDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPostageFinaceService {
    List<PostageFinaceDTO> findAll();
    List<PostageFinaceDTO> findAll(Pageable pageable);
    PostageFinaceDTO findById(Long id);
    PostageFinaceDTO save(PostageFinaceDTO postageFinaceDTO);
    PostageFinaceDTO update(PostageFinaceDTO postageFinaceDTO);
    void deleteOne(Long id);
    Integer count();
}
