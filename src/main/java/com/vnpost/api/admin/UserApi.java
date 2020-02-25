package com.vnpost.api.admin;

import com.vnpost.dto.UserDTO;
import com.vnpost.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "apiUser")
@RequestMapping("/api/user")
public class UserApi {
    @Autowired
    private UserService userService;
    @PostMapping
    public UserDTO save(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }
    @PutMapping
    public UserDTO update(@RequestBody UserDTO userDTO){
        return userService.update(userDTO);
    }
    @DeleteMapping
    public void delete(@RequestBody UserDTO userDTO){
        userService.delete(userDTO.getListId());
    }

    @PutMapping("/disable")
    public UserDTO disable(@RequestBody UserDTO userDTO){
        System.out.println("point");
        userService.disable(userDTO.getListId());
        return userDTO;
    }
    @PutMapping("/reset")
    public UserDTO reset(@RequestBody UserDTO userDTO){
        userService.resetAll(userDTO.getListId());
        return userDTO;
    }
    @PutMapping("/enable")
    public UserDTO enable(@RequestBody UserDTO userDTO){
        userService.enable(userDTO.getListId());
        return userDTO;
    }
}
