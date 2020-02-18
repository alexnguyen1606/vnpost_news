package com.vnpost.controller.admin;

import com.vnpost.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "adminCategoryController")
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    public ModelAndView listCategory(){
        ModelAndView mav = new ModelAndView("admin/category/list");
        mav.addObject("category",categoryService.findAll());
        return mav;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editCategory(@PathVariable(value = "id",required = false) Long categoryId){
        ModelAndView mav = new ModelAndView("admin/category/edit");
        mav.addObject("category",categoryService.findAll());
        return mav;
    }
}
