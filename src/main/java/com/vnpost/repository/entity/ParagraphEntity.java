package com.vnpost.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "paragraphs")
public class ParagraphEntity extends BaseEntity {
    @Column(name = "image")
    private String image;
    @Column(name = "titleImage")
    private String titleImage;
    @Column(name = "content",columnDefinition = "TEXT")
    private String content;
    @JsonIgnore
    @JoinColumn(name = "newsid")
    @ManyToOne
    private NewsEntity news;
}
