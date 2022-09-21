package com.vnpost.repository;

import com.vnpost.repository.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    //List<CategoryEntity> findById(Long id);
}
