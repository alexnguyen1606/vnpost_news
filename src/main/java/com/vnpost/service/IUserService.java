package com.vnpost.service;

import com.vnpost.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public interface IUserService {
    Page<UserDTO> findAll(Pageable pageable);

    List<UserDTO> findAll();

    UserDTO save(UserDTO userDTO);

    UserDTO update(UserDTO userDTO);

    UserDTO findByUsername(String username);

    List<UserDTO> findAllByStatus(int status);

    List<UserDTO> findAllByStatus(int status, Pageable pageable);

    List<UserDTO> findByStatusAndRole(int status, long roleId);

    void delete(Long[] ids);

    void enable(Long[] ids);

    void disable(Long[] ids);

    UserDTO findById(Long id);

    boolean existById(Long id);

    void resetPassword(Long id);

    void resetAll(Long[] ids);

    void deleteOne(Long id);

    void changePassWord(UserDTO userDTO);
}
