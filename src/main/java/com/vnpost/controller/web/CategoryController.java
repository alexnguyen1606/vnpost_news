package com.vnpost.controller.web;

import com.vnpost.utils.constant.SystemConstant;
import com.vnpost.dto.BaseDTO;
import com.vnpost.service.ICategoryService;
import com.vnpost.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller(value = "webCategoryController")
@RequestMapping("/bai-viet")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private INewsService newsService;
    @GetMapping(value = {"/nhom/{id}"})
    private String category(@PathVariable("id") Long id,
        @RequestParam(name = "page",required = false,defaultValue = "1") Integer page,
        @RequestParam(name = "size",required = false,defaultValue = "8") Integer size,
                            Model model
    ){
        BaseDTO baseModel = new BaseDTO();
        Integer totalItem = newsService.totalItem(id);
        baseModel.setId(id);
        baseModel.setPage(page);
        baseModel.setSize(size);
        baseModel.setTotalPages((int) Math.ceil((double)totalItem/size));
        Pageable pageable =  PageRequest.of(page-1,size);
        model.addAttribute("category",categoryService.findAll());
        model.addAttribute("news",newsService.findAllByCategoryIdAndStatus(id,SystemConstant.enable,pageable));
        model.addAttribute("model",baseModel);
        return "web/news/category";
    }
}
