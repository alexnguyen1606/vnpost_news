package com.vnpost.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users = new ArrayList<>();
}
