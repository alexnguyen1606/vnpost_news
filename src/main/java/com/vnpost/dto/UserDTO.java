package com.vnpost.dto;

import com.vnpost.annotations.Name;
import com.vnpost.annotations.Password;
import com.vnpost.annotations.Username;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDTO extends BaseDTO {
    @Username
    private String userName;

    @Password
    private String password;

    private String email;

    private String confirmPassword;
    private String oldPassword;

    private String fullName;


    private Integer status;

    private List<String> listRole = new ArrayList<>();

    private List<RoleDTO> roles = new ArrayList<>();

}
