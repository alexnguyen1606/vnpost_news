package com.vnpost.controller.api.web;

import com.vnpost.dto.NewsDTO;
import com.vnpost.service.INewsService;
import com.vnpost.utils.constant.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController(value = "apiWebNews")
public class NewsApi {
    @Autowired
    private INewsService newsService;

    @GetMapping("/api/web/news/search")
    public List<String> search() {
        Pageable pageable = PageRequest.of(0, 8);
        return newsService.findAllByStatus(SystemConstant.enable, pageable).stream()
                .map(NewsDTO::getName)
                .collect(Collectors.toList());
    }
}
