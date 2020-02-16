package com.vnpost.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class NewsDTO extends BaseDTO{

    private Integer status;

    private String name;

    private String title;


    private String url;

    private Integer count;

    private String author;

    private List<ParagraphDTO> listParagraph = new ArrayList<>();

    private SubCategoryDTO subCategory;
}
