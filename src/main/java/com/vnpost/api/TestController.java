package com.vnpost.api;

import com.vnpost.entity.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {
    @GetMapping("/api/test")
    public UserEntity findOne(){
        UserEntity userEntity = new UserEntity();
        userEntity.setCreatedBy("Abc");
        return userEntity;
    }
    @PostMapping("/api/test")
    public UserEntity save(@RequestBody UserEntity userEntity){
        userEntity.setModifiedDate(new Date());
        return userEntity;
    }
}
