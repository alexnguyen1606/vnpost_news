package com.vnpost.repository.custom;

import com.vnpost.dto.NewsBuilder;
import com.vnpost.repository.entity.NewsEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface NewsRepositoryCustom {
    List<NewsEntity> findAll(Map<String,Object> param, NewsBuilder builder, Pageable pageable);
    List<NewsEntity> findAll(Map<String,Object> param, NewsBuilder builder);
}
