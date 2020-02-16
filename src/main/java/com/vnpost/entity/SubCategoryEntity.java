package com.vnpost.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "subcategory")
@Entity
public class SubCategoryEntity extends BaseEntity{
    @Column(name = "url",length = 50)
    private String url;
    @Column(name = "name",length = 50,nullable = false,unique = true)
    private String name;
    @ManyToOne
    @JoinTable(name = "maincategoryid")
    private MainCategoryEntity mainCategory;

    @OneToMany(mappedBy = "subCategory",fetch = FetchType.LAZY)
    private List<NewsEntity> listNews = new ArrayList<>();
}
