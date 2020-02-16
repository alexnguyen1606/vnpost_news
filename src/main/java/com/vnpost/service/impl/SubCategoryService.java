package com.vnpost.service.impl;

import com.vnpost.converter.SubCategoryConverter;
import com.vnpost.dto.SubCategoryDTO;
import com.vnpost.repository.SubCategoryRepository;
import com.vnpost.service.ISubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubCategoryService implements ISubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private SubCategoryConverter categoryConverter;
    @Override
    public List<SubCategoryDTO> findByMainCategoryId(Long mainCategoryId) {
        return subCategoryRepository.findByMainCategoryId(mainCategoryId)
                .stream().map(item -> categoryConverter.convertToDTO(item)).collect(Collectors.toList());
    }
}
