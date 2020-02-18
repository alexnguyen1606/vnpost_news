package com.vnpost.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Table(name = "roles")
@Entity
public class RoleEntity extends BaseEntity {
    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "code",length = 50)
    private String code;

    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> listUsers = new ArrayList<>();
}
