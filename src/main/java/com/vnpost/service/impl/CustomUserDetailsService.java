package com.vnpost.service.impl;

import com.vnpost.constant.SystemConstant;
import com.vnpost.dto.CustomUserDetails;
import com.vnpost.dto.MyUser;
import com.vnpost.dto.UserDTO;
import com.vnpost.entity.RoleEntity;
import com.vnpost.entity.UserEntity;
import com.vnpost.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity role: user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }
        MyUser myUser = new MyUser
                (user.getUserName(),user.getPassword(),true,true,true,true,authorities);
        myUser.setFullName(user.getFullName());

        return myUser;
    }
}
