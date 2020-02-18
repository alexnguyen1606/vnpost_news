package com.vnpost.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryDTO extends BaseDTO {

    private String url;

    private String name;

    private List<NewsDTO> listNews = new ArrayList<>();

    private NewsDTO newsLatest;
    private NewsDTO newsMostViews;
}
