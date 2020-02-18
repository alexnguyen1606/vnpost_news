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
@Table(name = "news")
public class NewsEntity extends BaseEntity{
    @Column(name = "status",nullable = false)
    private Integer status;

    @NotBlank
    @Column(name = "name",length = 50)
    private String name;
    @Column(name = "title")
    private String title;
    @Column(name = "thumbnail")
    private String thumbnail;
    @Column(name = "url",length = 50)
    private String url;
    @Column(name = "count",columnDefinition = "integer default 0")
    private Integer count;
    @Column(name = "author",length = 50)
    private String author;

    @OneToMany(mappedBy = "news",fetch = FetchType.EAGER)
    private List<ParagraphEntity> listParagraph = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private CategoryEntity category;
}
