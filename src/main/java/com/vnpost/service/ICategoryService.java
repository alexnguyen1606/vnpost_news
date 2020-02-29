package com.vnpost.service;

import com.vnpost.dto.CategoryDTO;
import com.vnpost.dto.IndexDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> findAll();
    List<CategoryDTO> findAll(Pageable pageable);
    CategoryDTO findById(Long id);
    CategoryDTO save(CategoryDTO categoryDTO);
    CategoryDTO update(CategoryDTO categoryDTO);
    List<CategoryDTO> findByIdAndStatus(Long id ,Integer status);
    IndexDTO findIndexCategory();
    void delete(Long[] ids);
}
