package com.vnpost.api.admin;

import com.vnpost.dto.NewsDTO;
import com.vnpost.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "apiNews")
@RequestMapping("/api/news")
public class NewsApi {
    @Autowired
    private INewsService newsService;
    @PutMapping("/disable")
    public NewsDTO disableNews(@RequestBody NewsDTO newsDTO){
        newsService.disableAll(newsDTO.getListId());
        return newsDTO;
    }
    @PutMapping("/enable")
    public NewsDTO enableNews(@RequestBody NewsDTO newsDTO){
        newsService.enableAll(newsDTO.getListId());
        return newsDTO;
    }
    @DeleteMapping
    public void deleteNews(@RequestBody NewsDTO newsDTO){
        newsService.deleteAll(newsDTO.getListId());
    }
}
