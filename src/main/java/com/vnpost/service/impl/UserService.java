package com.vnpost.service.impl;

import com.vnpost.converter.UserConverter;
import com.vnpost.dto.UserDTO;
import com.vnpost.repository.RoleRepository;
import com.vnpost.repository.UserRepository;
import com.vnpost.repository.entity.UserEntity;
import com.vnpost.service.IRoleService;
import com.vnpost.service.IUserService;
import com.vnpost.utils.EncrytedPasswordUtils;
import com.vnpost.utils.SecurityUtils;
import com.vnpost.utils.constant.SystemConstant;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserService implements IUserService {

    UserRepository userRepository;
    RoleRepository roleRepository;
    UserConverter converter;
    IRoleService roleService;

    @Override
    public Page<UserDTO> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(converter::convertToDTO);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(converter::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        if (userDTO.getId() == null) {
            throw new RuntimeException("ID not allow");
        }
        userDTO.setPassword(SystemConstant.defaultPassword);
        UserEntity entity = converter.convertToEntity(userDTO);
        entity.setRoles(roleRepository.findByCodeIn(userDTO.getListRole()));
        userRepository.save(entity);
        return converter.convertToDTO(entity);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        userDTO.getListRole().stream()
                .map(roleService::findByCode)
                .forEach(role -> userDTO.getRoles().add(role));

        UserEntity entity = converter.convertToEntity(userDTO);
        UserEntity userEntityIndB = userRepository.findById(entity.getId()).orElseThrow(RuntimeException::new);
        entity.setPassword(userEntityIndB.getPassword());
        return converter.convertToDTO(userRepository.save(entity));
    }

    @Override
    public UserDTO findByUsername(String username) {
        return converter.convertToDTO(userRepository.findByUserName(username));
    }

    @Override
    public List<UserDTO> findAllByStatus(int status) {
        return userRepository.findByStatus(status).stream()
                .map(converter::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findAllByStatus(int status, Pageable pageable) {
        return userRepository.findByStatus(status, pageable)
                .stream()
                .map(converter::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findByStatusAndRole(int status, long roleId) {

        return userRepository.findByStatusAndRoles(status, roleRepository.findById(roleId).orElseThrow(RuntimeException::new))
                .stream()
                .map(converter::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(Long[] ids) {
        Arrays.stream(ids).forEach(this::deleteOne);
    }

    @Override
    public void enable(Long[] ids) {
        Arrays.stream(ids)
                .map(this::findById)
                .forEach(userDTO -> {
                    userDTO.setStatus(SystemConstant.enable);
                    update(userDTO);
                });
    }

    @Override
    public void disable(Long[] ids) {
        for (Long id : ids) {
            UserDTO userDTO = findById(id);
            userDTO.setStatus(SystemConstant.disable);
            update(userDTO);
        }
    }

    @Override
    public UserDTO findById(Long id) {
        return userRepository.findById(id)
                .map(converter::convertToDTO)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public boolean existById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public void resetPassword(Long id) {
        UserDTO userDTO = findById(id);
        userDTO.setPassword(SystemConstant.defaultPassword);
        UserEntity entity = converter.convertToEntity(userDTO);
        userRepository.save(entity);

    }

    @Override
    public void resetAll(Long[] ids) {
        Arrays.stream(ids).forEach(this::resetPassword);
    }

    @Override
    public void deleteOne(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(RuntimeException::new);
        userEntity.getRoles().clear();
        userRepository.delete(userEntity);
    }

    @Override
    public void changePassWord(UserDTO userDTO) {
        String passwordEncoder = EncrytedPasswordUtils.encrytePassword(userDTO.getOldPassword());
        UserDTO userInDb = findByUsername(SecurityUtils.getPrincipal().getUsername());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!bCryptPasswordEncoder.matches(passwordEncoder, userInDb.getPassword())) {
            throw new RuntimeException("Password not match");
        }
        UserEntity entity = converter.convertToEntity(userInDb);
        entity.setPassword(EncrytedPasswordUtils.encrytePassword(userDTO.getPassword()));
        userRepository.save(entity);
    }
}
