package com.vnpost.repository.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "roles")
@Entity
public class RoleEntity extends BaseEntity {
    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "code",length = 50)
    private String code;
    @JsonIgnore
    @ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL)
    private List<UserEntity> users = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
