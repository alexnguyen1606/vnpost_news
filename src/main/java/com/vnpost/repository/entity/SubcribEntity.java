package com.vnpost.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "subcrib")
@Entity
public class SubcribEntity extends BaseEntity{
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "name")
    private String name;
}
