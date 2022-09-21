package com.vnpost.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

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

    @Column(columnDefinition = "TEXT")
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    private String thumbnail;

    private String url;

    private Integer count;

    private String author;

    @JsonIgnore
    @OneToMany(mappedBy = "news",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<ParagraphEntity> listParagraph = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private CategoryEntity category;

    public void incrementView() {
        if (isNull(count)) {
            count = 0;
        }
        count++;
    }
}
