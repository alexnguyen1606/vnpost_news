package com.vnpost.service.impl;

import com.vnpost.converter.RoleConverter;
import com.vnpost.dto.RoleDTO;
import com.vnpost.repository.RoleRepository;
import com.vnpost.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleConverter converter;
    @Override
    public List<RoleDTO> findAll() {
        return roleRepository.findAll().stream()
                .map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public RoleDTO findByCode(String code) {
        return converter.convertToDTO(roleRepository.findByCode(code));
    }
}
