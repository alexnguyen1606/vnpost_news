package com.vnpost.api.web;

import com.vnpost.constant.SystemConstant;
import com.vnpost.service.INewsService;
import com.vnpost.service.impl.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController(value = "apiWebNews")
public class NewsApi {
    @Autowired
    private INewsService newsService;

    @GetMapping("/api/web/news/search")
    public List<String> search(){
        List<String> result = new ArrayList<>();
        Pageable pageable = PageRequest.of( 0, 8);
        newsService.findAllByStatus(SystemConstant.enable,pageable).stream()
                .map(item -> result.add(item.getName())).collect(Collectors.toList());
        return result;
    }
}
