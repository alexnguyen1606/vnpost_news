package com.vnpost.controller.web;

import com.vnpost.dto.NewsBuilder;
import com.vnpost.utils.constant.SystemConstant;
import com.vnpost.dto.NewsDTO;
import com.vnpost.service.INewsService;
import com.vnpost.service.impl.CategoryService;
import com.vnpost.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller(value = "webNewsController")
public class NewsController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private INewsService newsService;
    @GetMapping("/tin-tuc/tim-kiem")
    public ModelAndView search(@RequestParam(value = "key",required = false) String search

    ){
        ModelAndView mav = new ModelAndView("web/news/search");
       // String searchEnglish = StringUtils.convertEnglish(search);
        NewsBuilder builder = NewsBuilder.builder()
                .name(search)
               // .categoryName(search)
                .author(search)
                .title(search)
                .url(StringUtils.convert(search))
                .categoryUrl(StringUtils.convert(search))
                .status(SystemConstant.enable)
                .build();
        List<NewsDTO> result = newsService.search(builder);
        mav.addObject("news",result);
        mav.addObject("key",search);
        return mav;
    }
    @GetMapping("/tin-tuc")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("web/news/index");
        mav.addObject("lastedNews",newsService.findLatest());
        mav.addObject("mostViews",newsService.findMostViews());
        mav.addObject("newest",newsService.findLatest().get(0));
        mav.addObject("category",categoryService.findAll());
        return mav;
    }
    @GetMapping("/bai-viet/chi-tiet/{id}")
    public String detail(@PathVariable("id") Long idNews, Model model){
            NewsDTO news = newsService.findById(idNews);
            newsService.countViews(news.getId());
            model.addAttribute("category",categoryService.findAll());
            model.addAttribute("newsItem",news);
            model.addAttribute("news",newsService.findAllByCategoryIdAndStatus(news.getCategory().getId(), SystemConstant.enable));
            return "web/news/detail";
    }

}
