package com.vnpost.controller.web;

import com.vnpost.constant.SystemConstant;
import com.vnpost.service.ICategoryService;
import com.vnpost.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "webCategoryController")
@RequestMapping("/bai-viet")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private INewsService newsService;
    @GetMapping("/nhom/id/{id}/key/{key}")
    private ModelAndView category(@PathVariable("id") Long id,@PathVariable("key") String key ){
        ModelAndView mav = new ModelAndView("web/news/category");
        mav.addObject("category",categoryService.findAll());
        mav.addObject("news",newsService.findAllByCategoryIdAndStatus(id, SystemConstant.enable));
        return mav;
    }
}
