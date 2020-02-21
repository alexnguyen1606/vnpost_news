package com.vnpost.api.admin;

import com.vnpost.constant.SystemConstant;
import com.vnpost.dto.NewsDTO;
import com.vnpost.dto.TestDTO;
import com.vnpost.service.INewsService;
import com.vnpost.utils.UploadFileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController(value = "apiNews")
@RequestMapping("/api/news")
public class NewsApi {
    @Autowired
    private UploadFileUtils uploadFileUtils;
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
    @GetMapping
    public List<String> search(){
        List<NewsDTO> listNews = newsService.findAllByStatus(SystemConstant.enable);
        List<String> listString = new ArrayList<>();
        for (NewsDTO newsDTO : listNews){
            listString.add(newsDTO.getName());
        }
        return listString;
    }
    @PostMapping
    public NewsDTO save(@RequestBody NewsDTO newsDTO){
        return newsService.save(newsDTO);
    }
    @PutMapping
    public NewsDTO update(@RequestBody NewsDTO newsDTO){
        return newsService.update(newsDTO);
    }
    @DeleteMapping
    public void deleteNews(@RequestBody NewsDTO newsDTO){
        newsService.deleteAll(newsDTO.getListId());
    }
    @ResponseBody
    @PostMapping("/test")
    public void save(@RequestBody TestDTO testDTO){
        byte[] bytes = Base64.getDecoder().decode(StringUtils.substringBefore(testDTO.getBase64(),","));
        uploadFileUtils.writeOrUpdate(bytes,testDTO.getName());
    }
}
