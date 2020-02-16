package com.vnpost.service;

import com.vnpost.dto.NewsDTO;

import java.util.List;

public interface INewsService {
    List<NewsDTO> findAll();
    List<NewsDTO> findAllBySubCategoryId(Long subCategoryId);
    List<NewsDTO> findAllByStatus(Integer status);
    List<NewsDTO> findAllBySubCategoryIdAndStatus(Long subCategoryId,Integer status);
    NewsDTO save(NewsDTO newsDTO);
    NewsDTO update(NewsDTO newsDTO);
    NewsDTO findById(Long id);
    NewsDTO findByUrl(String url);
    void disable(NewsDTO newsDTO);
    void deleteAll(Long[] ids);
    void deleteOne(Long id);
}
