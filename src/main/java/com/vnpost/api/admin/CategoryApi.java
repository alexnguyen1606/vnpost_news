package com.vnpost.api.admin;

import com.vnpost.dto.CategoryDTO;
import com.vnpost.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "apiCategory")
@RequestMapping("/api/category")
public class CategoryApi {
    @Autowired
    private ICategoryService categoryService;
    @PostMapping
    public CategoryDTO save(@RequestBody CategoryDTO categoryDTO){
        return categoryService.save(categoryDTO);
    }
    @PutMapping
    public CategoryDTO update(@RequestBody CategoryDTO categoryDTO){
        return categoryService.update(categoryDTO);
    }

}
