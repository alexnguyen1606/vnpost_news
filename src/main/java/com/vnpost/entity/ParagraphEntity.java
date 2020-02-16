package com.vnpost.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "paragraphs")
public class ParagraphEntity extends BaseEntity {
    @Column(name = "image")
    private String imgage;
    @Column(name = "titleImage")
    private String titleImage;
    @Column(name = "content")
    private String content;
    @JoinTable(name = "newsid")
    @ManyToOne
    private NewsEntity news;
}
