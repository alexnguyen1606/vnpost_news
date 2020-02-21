package com.vnpost.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDTO extends BaseDTO {

    private String userName;


    private String password;

    private String repeatPassword;


    private String fullName;


    private Integer status;
    private List<String> listRole = new ArrayList<>();

    private List<RoleDTO> roles = new ArrayList<>();
}
