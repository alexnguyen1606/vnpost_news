package com.vnpost.service;

import com.vnpost.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public interface IUserService {
    public ArrayList<UserDTO> findAll();
    UserDTO save(UserDTO userDTO);
    UserDTO update(UserDTO userDTO);
    UserDTO findByUsername(String username);
   // UserDTO findOne(Long id);
    //List<UserDTO> findAllByStatusAndRoleIdAndBuildingId(int status, long roleId, Long buildingId);
    List<UserDTO> findAllByStatus(int status);
    List<UserDTO> findByStatusAndRole(int status, long roleId);
}
