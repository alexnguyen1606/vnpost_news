package com.vnpost.controller.api.admin;

import com.vnpost.dto.NewsDTO;
import com.vnpost.service.INewsService;
import com.vnpost.utils.UploadFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "apiNews")
@RequestMapping("/api/news")
public class NewsApi {
    @Autowired
    private UploadFileUtils uploadFileUtils;
    @Autowired
    private INewsService newsService;

    @PutMapping("/disable")
    public void disableNews(@RequestBody NewsDTO newsDTO) {
        newsService.disableAll(newsDTO.getListId());
    }

    @PutMapping("/enable")
    public void enableNews(@RequestBody NewsDTO newsDTO) {
        newsService.enableAll(newsDTO.getListId());
    }

    @PostMapping
    public void save(@RequestBody NewsDTO newsDTO) {
        newsService.save(newsDTO);
    }

    @PutMapping
    public void update(@RequestBody NewsDTO newsDTO) {
        newsService.update(newsDTO);
    }

    @DeleteMapping
    public void deleteNews(@RequestBody NewsDTO newsDTO) {
        newsService.deleteAll(newsDTO.getListId());
    }

}
