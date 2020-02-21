package com.vnpost.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ParagraphDTO extends BaseDTO{
    private MultipartFile multipartFile;
    private String image;
    private String titleImage;
    private String content;
    private NewsDTO news;
}
