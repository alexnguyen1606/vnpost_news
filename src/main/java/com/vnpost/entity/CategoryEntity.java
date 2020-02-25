package com.vnpost.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "category")
@Entity
public class CategoryEntity extends BaseEntity{
    @Column(name = "url",length = 50)
    private String url;
    @Column(name = "name",length = 50,nullable = false,unique = true)
    private String name;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<NewsEntity> listNews = new ArrayList<>();
}
