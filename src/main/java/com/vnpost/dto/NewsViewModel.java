package com.vnpost.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsViewModel {
    private NewsDTO news;
    private Long categoryId;
}
