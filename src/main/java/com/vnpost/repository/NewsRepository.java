package com.vnpost.repository;

import com.vnpost.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity,Long> {
    @Query("select n from NewsEntity n where n.status=?1 ORDER BY n.createdDate DESC")
    List<NewsEntity> findByStatusDesc(Integer status);

    List<NewsEntity> findByStatus(Integer status);

    List<NewsEntity> findByCategoryIdAndStatus(Long subCategory,Integer status);
    List<NewsRepository> findByNameLike(String search);

}
