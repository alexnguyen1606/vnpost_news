package com.vnpost.controller.api.admin;

import com.vnpost.dto.UserDTO;
import com.vnpost.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController(value = "apiUser")
@RequestMapping("/api/user")
public class UserApi {
    @Autowired
    private UserService userService;

    @PostMapping
    public void save(@Valid @RequestBody UserDTO userDTO) {
        userService.save(userDTO);
    }

    @PutMapping
    public void update(@Valid @RequestBody UserDTO userDTO) {
        userService.update(userDTO);
    }

    @DeleteMapping
    public void delete(@RequestBody UserDTO userDTO) {
        userService.delete(userDTO.getListId());
    }

    @PutMapping("/disable")
    public void disable(@RequestBody UserDTO userDTO) {
        userService.disable(userDTO.getListId());
    }

    @PutMapping("/reset")
    public void reset(@RequestBody UserDTO userDTO) {
        userService.resetAll(userDTO.getListId());
    }

    @PutMapping("/enable")
    public void enable(@RequestBody UserDTO userDTO) {
        userService.enable(userDTO.getListId());
    }
}
