package com.vnpost.repository;

import com.vnpost.entity.MainCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategoryEntity,Long> {
    MainCategoryEntity findByUrl(String url);
}
