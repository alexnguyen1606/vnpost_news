package com.vnpost.repository;

import com.vnpost.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity,Long> {
    List<NewsEntity> findAllByStatus(Integer status);
    List<NewsEntity> findAllBySubCategoryIdAndStatus(Long subCategory,Integer status);
    List<NewsEntity> findAllBySubCategoryId(Long subCategory);
    NewsEntity findByUrl(String url);
}
