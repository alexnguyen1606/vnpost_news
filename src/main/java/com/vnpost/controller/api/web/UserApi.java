package com.vnpost.controller.api.web;

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

}
