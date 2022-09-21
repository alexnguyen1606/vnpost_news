package com.vnpost.repository;

import com.vnpost.repository.entity.ParagraphEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParagraphRepository extends JpaRepository<ParagraphEntity,Long> {
    List<ParagraphEntity> findByNewsId(Long newsId);
}
