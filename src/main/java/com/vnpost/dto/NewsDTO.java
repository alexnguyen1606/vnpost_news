package com.vnpost.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class NewsDTO extends BaseDTO{

    private Integer status;

    private String name;
    private String content;

    private String title;

    private String thumbnail;

    private MultipartFile thumbnailMultipartFile;

    private String url;

    private Integer count;

    private String author;

    private Long cateId;

    private ParagraphDTO paragraph1;
    private ParagraphDTO paragraph2;
    private ParagraphDTO paragraph3;

    private List<ParagraphDTO> listParagraph = new ArrayList<>();
    //private Long categoryId;

    private CategoryDTO category;
}
