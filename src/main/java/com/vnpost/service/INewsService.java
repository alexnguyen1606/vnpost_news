package com.vnpost.service;

import com.vnpost.builder.NewsBuilder;
import com.vnpost.dto.NewsDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewsService {
    List<NewsDTO> findAll(Pageable pageable);
    List<NewsDTO> findAll();
    List<NewsDTO> findAllByStatus(Integer status,Pageable pageable);
    List<NewsDTO> findAllByStatus(Integer status);
    List<NewsDTO> findAllByCategoryIdAndStatus(Long categoryId,Integer status);
    List<NewsDTO> findAllByCategoryIdAndStatus(Long categoryId, Integer status, Pageable pageable);
    Integer totalItem(Long categoryId);
    NewsDTO save(NewsDTO newsDTO);
    NewsDTO update(NewsDTO newsDTO);
    NewsDTO findById(Long id);
    NewsDTO findByIdAndStatus(Long id,Integer status);
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
    List<NewsDTO> search(NewsBuilder builder);
    List<NewsDTO> search(NewsBuilder builder,Pageable pageable);
    List<NewsDTO> searchByAdmin(NewsDTO newsDTO,Pageable pageable);
}
