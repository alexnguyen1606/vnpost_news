package com.vnpost.repository;

import com.vnpost.repository.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    RoleEntity findByCode(String code);

    List<RoleEntity> findByCodeIn(List<String> codes);
}
