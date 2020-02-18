package com.vnpost.repository.custom;

import com.vnpost.entity.NewsEntity;

import java.util.List;

public interface NewsRepositoryCustom {
    List<NewsEntity> findLatestByCategoryId(Long categoryId);
    List<NewsEntity> findLastestByStatus();
}
