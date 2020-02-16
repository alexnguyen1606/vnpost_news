package com.vnpost.service;

import com.vnpost.dto.SubCategoryDTO;

import java.util.List;

public interface ISubCategoryService {
    List<SubCategoryDTO> findByMainCategoryId(Long mainCategoryId);
}
