package com.vnpost.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewsController {

    @GetMapping("/tin-tuc")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("web/news/index");
        mav.addObject("category","");
        return mav;
    }
    @GetMapping("/detail")
    public ModelAndView detail(){
        ModelAndView mav = new ModelAndView("web/news/detail");
        return mav;
    }
    @GetMapping("/category")
    private ModelAndView category(){
        ModelAndView mav = new ModelAndView("web/news/category");
        return mav;
    }
}
