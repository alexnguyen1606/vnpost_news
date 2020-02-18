package com.vnpost.controller.admin;

import com.vnpost.constant.SystemConstant;
import com.vnpost.dto.NewsDTO;
import com.vnpost.service.ICategoryService;
import com.vnpost.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller(value = "adminNewsController")
@RequestMapping("/admin/news")
public class NewsController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private INewsService newsService;
    @GetMapping
    public ModelAndView listNews(){
        ModelAndView mav = new ModelAndView("admin/news/list");
        mav.addObject("news",newsService.findAllByStatus(SystemConstant.enable));
        return mav;
    }
    @GetMapping("/disable")
    public ModelAndView listNewsDisable(){
        ModelAndView mav = new ModelAndView("admin/news/list");
        mav.addObject("news",newsService.findAllByStatus(SystemConstant.disable));
        return mav;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editNews(@PathVariable(value = "id",required = false) Long idNews){
        ModelAndView mav = new ModelAndView("admin/news/edit");
        mav.addObject("newsItem",newsService.findById(idNews));
        mav.addObject("category",categoryService.findAll());
        return mav;
    }
    @PostMapping("/edit")
    public RedirectView save(@ModelAttribute("modelInView") NewsDTO newsItem){
        RedirectView rv = new RedirectView("/admin/news");
        if (newsItem.getId()==null){
            newsService.save(newsItem);
        }else {
            newsService.update(newsItem);
        }
        return rv;
    }
}
