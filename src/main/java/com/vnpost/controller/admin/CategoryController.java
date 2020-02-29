package com.vnpost.controller.admin;

import com.vnpost.dto.BaseDTO;
import com.vnpost.dto.CategoryDTO;
import com.vnpost.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "adminCategoryController")
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping
    public ModelAndView listCategory(
       @RequestParam(name = "page",required = false,defaultValue = "1") Integer page
       ,@RequestParam(name = "size",required = false,defaultValue = "7") Integer size
    ){
        BaseDTO baseModel = new BaseDTO();
        Integer totalItem = categoryService.findAll().size();
        baseModel.setSize(size);
        baseModel.setPage(page);
        baseModel.setTotalPages((int)Math.ceil((double)totalItem/size));
        Pageable pageable = PageRequest.of(page-1,size);
        ModelAndView mav = new ModelAndView("admin/category/list");
        mav.addObject("category",categoryService.findAll(pageable));
        mav.addObject("model",baseModel);
        return mav;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editCategory(@PathVariable(value = "id",required = false) Long categoryId){
        ModelAndView mav = new ModelAndView("admin/category/edit");
        if (categoryId==null){
            mav.addObject("category",new CategoryDTO());
        }else {
            mav.addObject("category",categoryService.findById(categoryId));
        }
        return mav;
    }
    @GetMapping("/create")
    public ModelAndView createCategory(){
        ModelAndView mav = new ModelAndView("admin/category/edit");
            mav.addObject("category",new CategoryDTO());
        return mav;
    }
    @PostMapping("/edit")
    public ModelAndView save(@ModelAttribute("category") CategoryDTO category){
        ModelAndView mav = new ModelAndView("/admin/category/list");
        if (category.getId()==null){
            categoryService.save(category);
        }else {
            categoryService.update(category);
        }
        mav.addObject("category",categoryService.findAll());
        return mav;
    }
}
