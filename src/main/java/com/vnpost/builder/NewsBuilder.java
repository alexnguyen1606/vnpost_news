package com.vnpost.builder;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NewsBuilder {
    private String name;
    private String categoryName;
    private String categoryUrl;
    private Long categoryId;
    private Integer status;
    private String author;
    private String title;
    private String url;
}
