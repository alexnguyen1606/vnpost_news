package com.vnpost.repository;

import com.vnpost.entity.NewsEntity;
import com.vnpost.repository.custom.NewsRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity,Long> , NewsRepositoryCustom {
    List<NewsEntity> findAllByStatus(Integer status);
    List<NewsEntity> findAllByCategoryIdAndStatus(Long subCategory,Integer status);
    List<NewsEntity> findAllByCategoryId(Long categoryId);
    NewsEntity findByUrl(String url);



}
