package com.vnpost.service;

import com.vnpost.dto.RoleDTO;

import java.util.List;

public interface IRoleService {
    List<RoleDTO> findAll();
    RoleDTO findByCode(String code);
}
