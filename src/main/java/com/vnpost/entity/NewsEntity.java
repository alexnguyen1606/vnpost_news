package com.vnpost.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "news")
public class NewsEntity extends BaseEntity{
    @Column(name = "status",nullable = false)
    private Integer status;
    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "title",columnDefinition = "TEXT")
    private String title;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "url")
    private String url;

    @Column(name = "count")
    private Integer count;

    @Column(name = "author")
    private String author;

    @OneToMany(mappedBy = "news",fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<ParagraphEntity> listParagraph = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private CategoryEntity category;
}
