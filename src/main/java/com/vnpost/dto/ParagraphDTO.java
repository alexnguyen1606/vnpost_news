package com.vnpost.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParagraphDTO extends BaseDTO{

    private String imgage;

    private String titleImage;
    private NewsDTO news;
    private String content;
}
