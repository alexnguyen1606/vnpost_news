package com.vnpost.repository;

import com.vnpost.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity,Long> {
    List<SubCategoryEntity> findByMainCategoryId(Long id);
}
