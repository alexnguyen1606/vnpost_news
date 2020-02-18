package com.vnpost.service.impl;

import com.vnpost.converter.UserConverter;
import com.vnpost.dto.UserDTO;
import com.vnpost.entity.UserEntity;
import com.vnpost.repository.RoleRepository;
import com.vnpost.repository.UserRepository;
import com.vnpost.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserConverter converter;
    @Override
    public ArrayList<UserDTO> findAll() {
        return (ArrayList<UserDTO>) userRepository.findAll().stream()
                .map(item-> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        if (userDTO.getId()==null){
            UserEntity entity = converter.convertToEntity(userDTO);
            return converter.convertToDTO(userRepository.save(entity));
        }
        return new UserDTO();
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        if (userDTO.getId()!=null){
            UserEntity entity = converter.convertToEntity(userDTO);
            return converter.convertToDTO(userRepository.save(entity));
        }
        return new UserDTO();
    }

    @Override
    public UserDTO findByUsername(String username) {
        return converter.convertToDTO(userRepository.findByUserName(username));
    }


    @Override
    public List<UserDTO> findAllByStatus(int status) {
        return userRepository.findAllByStatus(status).stream()
                .map(item-> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findByStatusAndRole(int status, long roleId) {
        return userRepository.findAllByStatusAndRoles(status,roleRepository.findById(roleId).get()).stream()
                .map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }
}
