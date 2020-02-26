package com.vnpost.service.impl;

import com.vnpost.constant.SystemConstant;
import com.vnpost.converter.UserConverter;
import com.vnpost.dto.RoleDTO;
import com.vnpost.dto.UserDTO;
import com.vnpost.entity.RoleEntity;
import com.vnpost.entity.UserEntity;
import com.vnpost.repository.RoleRepository;
import com.vnpost.repository.UserRepository;
import com.vnpost.service.IRoleService;
import com.vnpost.service.IUserService;
import com.vnpost.utils.EncrytedPasswordUtils;
import com.vnpost.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserConverter converter;
    @Autowired
    private IRoleService roleService;
    @Override
    public ArrayList<UserDTO> findAll() {
        return (ArrayList<UserDTO>) userRepository.findAll().stream()
                .map(item-> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        if (userDTO.getId()==null){
            userDTO.setPassword(SystemConstant.defaultPassword);
            UserEntity entity = converter.convertToEntity(userDTO);
            UserEntity entity1 = null;
            try {
                 entity1= userRepository.save(entity);
                 for (String code : userDTO.getListRole()){
                     entity1.getRoles().add(roleRepository.findByCode(code));
                 }
                 userRepository.save(entity1);
            }catch (Exception e){
                System.out.println(e.toString());
            }

            return converter.convertToDTO(entity1);
        }
        return new UserDTO();
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        if (userDTO.getId()!=null){
            for (String code : userDTO.getListRole()){
                RoleDTO role = roleService.findByCode(code);
                userDTO.getRoles().add(role);
            }
            UserEntity entity = converter.convertToEntity(userDTO);
            UserEntity userEntityIndB = userRepository.findById(entity.getId()).get();
            entity.setPassword(userEntityIndB.getPassword());
            entity.setCreatedBy(userEntityIndB.getCreatedBy());
            entity.setCreatedDate(userEntityIndB.getCreatedDate());
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
        return userRepository.findByStatus(status).stream()
                .map(item-> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findByStatusAndRole(int status, long roleId) {
        return userRepository.findByStatusAndRoles(status,roleRepository.findById(roleId).get()).stream()
                .map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids){
            deleteOne(id);
        }
    }

    @Override
    public void enable(Long[] ids) {
        for (Long id : ids){
            UserDTO userDTO = findById(id);
            userDTO.setStatus(SystemConstant.enable);
            update(userDTO);
        }
    }

    @Override
    public void disable(Long[] ids) {
        for (Long id : ids){
            UserDTO userDTO = findById(id);
            userDTO.setStatus(SystemConstant.disable);
            update(userDTO);
        }
    }

    @Override
    public UserDTO findById(Long id) {
        if (existById(id)){
            return converter.convertToDTO(userRepository.findById(id).get());
        }
        return new UserDTO();
    }

    @Override
    public boolean existById(Long id) {
        if (userRepository.existsById(id)){
            return true;
        }
        return false;
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
        for (Long id: ids) {
            resetPassword(id);
        }
    }

    @Override
    public void deleteOne(Long id) {
        if (existById(id)){
            UserEntity userEntity = userRepository.findById(id).get();
            userEntity.getRoles().clear();
            userRepository.save(userEntity);
            userRepository.deleteById(id);
        }
    }

    @Override
    public void changePassWord(UserDTO userDTO) {
        String passwordEncoder = EncrytedPasswordUtils.encrytePassword(userDTO.getRepeatPassword());
        UserDTO userInDb = findByUsername(SecurityUtils.getPrincipal().getUsername());
        if (userInDb.getId()!=null){
            if (bCryptPasswordEncoder.matches(passwordEncoder,userInDb.getPassword())){
                UserEntity entity = converter.convertToEntity(userInDb);
                entity.setPassword(EncrytedPasswordUtils.encrytePassword(userDTO.getPassword()));
                entity.setCreatedDate(entity.getCreatedDate());
                entity.setCreatedBy(entity.getCreatedBy());
                userRepository.save(entity);
            }
        }

    }
}
