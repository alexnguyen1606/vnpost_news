package com.vnpost.service;

import com.vnpost.dto.MainCategoryDTO;

import java.util.List;

public interface IMainCategoryService {
    List<MainCategoryDTO> findAll();
    MainCategoryDTO save(MainCategoryDTO mainCategoryDTO);
    MainCategoryDTO update(MainCategoryDTO mainCategoryDTO);
    void deleteOne(Long id);
    MainCategoryDTO findByUrl(String url);
    MainCategoryDTO findById(Long id);
}
