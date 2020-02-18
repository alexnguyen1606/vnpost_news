package com.vnpost.repository;

import com.vnpost.entity.RoleEntity;
import com.vnpost.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findOneByUserNameAndStatus(String name, int status);
    List<UserEntity> findAllByStatus(int status);
    List<UserEntity> findAllByStatusAndRoles(int status, RoleEntity roleEntity);
    UserEntity findByUserName(String username);
}
