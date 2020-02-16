package com.vnpost.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RoleDTO extends BaseDTO {

    private String name;

    private String code;


    private List<UserDTO> listUsers = new ArrayList<>();
}
