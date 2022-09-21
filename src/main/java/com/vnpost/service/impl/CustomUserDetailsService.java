package com.vnpost.service.impl;

import com.vnpost.dto.MyUser;
import com.vnpost.repository.UserRepository;
import com.vnpost.repository.entity.RoleEntity;
import com.vnpost.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username);
        if (isNull(user)) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(RoleEntity::getCode)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        MyUser myUser = new MyUser
                (user.getUserName(),user.getPassword(),true,true,true,true,authorities);
        myUser.setFullName(user.getFullName());

        return myUser;
    }
}
