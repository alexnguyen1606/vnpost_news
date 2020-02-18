package com.vnpost.repository;

import com.vnpost.entity.SubcribEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcribRepository extends JpaRepository<SubcribEntity,Long> {

}
