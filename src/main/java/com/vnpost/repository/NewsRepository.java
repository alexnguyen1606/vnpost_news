package com.vnpost.repository;

import com.vnpost.entity.NewsEntity;
import com.vnpost.repository.custom.NewsRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity,Long>, NewsRepositoryCustom {
    @Query("select n from NewsEntity n where n.status=?1 ORDER BY n.createdDate DESC")
    List<NewsEntity> findByStatusDesc(Integer status);

    List<NewsEntity> findByStatus(Integer status,Pageable pageable);
    List<NewsEntity> findByStatus(Integer status);
    NewsEntity findByIdAndStatus(Long id,Integer status);

    List<NewsEntity> findByCategoryIdAndStatus(Long subCategory,Integer status);
    List<NewsEntity> findByCategoryIdAndStatus(Long subCategory, Integer status, Pageable pageable);
    List<NewsRepository> findByNameLike(String search);

}
