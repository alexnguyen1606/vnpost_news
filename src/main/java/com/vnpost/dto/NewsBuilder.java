package com.vnpost.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;

@Builder
@Getter
@FieldNameConstants
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
