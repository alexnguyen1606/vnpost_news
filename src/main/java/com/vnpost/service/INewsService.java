package com.vnpost.service;

import com.vnpost.dto.NewsDTO;

import java.util.List;

public interface INewsService {
    List<NewsDTO> findAll();

    List<NewsDTO> findAllByStatus(Integer status);
    List<NewsDTO> findAllByCategoryIdAndStatus(Long subCategoryId,Integer status);
    NewsDTO save(NewsDTO newsDTO);
    NewsDTO update(NewsDTO newsDTO);
    NewsDTO findById(Long id);
    //NewsDTO findByUrl(String url);
    void disableNews(NewsDTO newsDTO);
    void enableNews(NewsDTO newsDTO);
    void disableAll(Long[] ids);
    void enableAll(Long[] ids);
    void deleteAll(Long[] ids);
    void deleteOne(Long id);
    NewsDTO findMostViewsByCategoryId(Long id);
    NewsDTO findMostViews();
    void countViews(Long id);
    Boolean exitsById(Long id);
    List<NewsDTO> findLatest();
    List<NewsDTO> search(String search);
}
