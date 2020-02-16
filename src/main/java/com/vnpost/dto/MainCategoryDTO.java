package com.vnpost.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MainCategoryDTO extends BaseDTO {
    private String url;

    private String name;


    private List<SubCategoryDTO> listSubCategory= new ArrayList<>();


   // private List<NewsDTO> listNews = new ArrayList<>();
}
