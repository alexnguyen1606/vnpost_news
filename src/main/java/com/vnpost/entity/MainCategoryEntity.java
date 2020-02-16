package com.vnpost.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "maincategory")
public class MainCategoryEntity extends BaseEntity{
    @NotBlank
    @Column(name = "url",length = 50)
    private String url;
    @NotBlank
    @Column(name = "name",length = 50,unique = true)
    private String name;

    @OneToMany(mappedBy = "mainCategory",fetch = FetchType.EAGER)
    private  List<SubCategoryEntity> listSubCategory= new ArrayList<>();

//    @OneToMany(fetch = FetchType.LAZY,mappedBy = "mainCategory")
//    private List<NewsEntity> listNews = new ArrayList<>();

}
