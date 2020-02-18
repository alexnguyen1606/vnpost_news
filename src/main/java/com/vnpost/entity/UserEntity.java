package com.vnpost.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Table(name ="users" )
@Entity
public class UserEntity extends BaseEntity {
    @NotNull
    @NotBlank
    @Column(name = "username",length = 255,nullable = false,unique = true)
    private String userName;
    @NotNull
    @NotBlank
    @Column(name = "password",length = 255,nullable = false)
    private String password;

    @Column(name = "fullname")
    private String fullName;

    @Column
    private Integer status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "roleid"))
    private List<RoleEntity> roles = new ArrayList<>();
}
