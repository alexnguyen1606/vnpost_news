package com.vnpost.api.web;

import com.vnpost.dto.UserDTO;
import com.vnpost.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "apiWebUser")
public class UserApi {
    @Autowired
    private IUserService userService;
    @PutMapping("/api/user/changeinfo")
    public void changePassword(@RequestBody UserDTO userDTO){
        userService.changePassWord(userDTO);
    }
}
