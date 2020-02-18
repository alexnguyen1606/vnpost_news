package com.vnpost.controller.web;

import com.vnpost.dto.IndexDTO;
import com.vnpost.dto.NewsDTO;
import com.vnpost.service.INewsService;
import com.vnpost.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "webNewsController")
public class NewsController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private INewsService newsService;
    @GetMapping("/tin-tuc")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("web/news/index");
        mav.addObject("indexCategory",new IndexDTO());
        mav.addObject("category",categoryService.findAll());
        return mav;
    }
    @GetMapping("/bai-viet/chi-tiet/id/{id}/key/{key}")
    public ModelAndView detail(@PathVariable("id") Long idNews,@PathVariable("key") String keyNews){
        ModelAndView mav = new ModelAndView("web/news/detail");
        NewsDTO news = newsService.findById(idNews);
      //  newsService.countViews(news.getId());
        mav.addObject("category",categoryService.findAll());
        mav.addObject("newsItem",news);
        return mav;
    }

}
