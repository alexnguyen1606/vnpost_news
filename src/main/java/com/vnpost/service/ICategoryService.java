package com.vnpost.service;

import com.vnpost.dto.CategoryDTO;
import com.vnpost.dto.IndexDTO;

import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> findAll();
    CategoryDTO findById(Long id);
    CategoryDTO save(CategoryDTO categoryDTO);
    CategoryDTO update(CategoryDTO categoryDTO);
    List<CategoryDTO> findByIdAndStatus(Long id ,Integer status);
    IndexDTO findIndexCategory();
    void delete(Long[] ids);
}
