package com.vnpost.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IndexDTO {
    private NewsDTO mostViews;
    private List<NewsDTO> listOlder;
    private NewsDTO newsLastest;
}
