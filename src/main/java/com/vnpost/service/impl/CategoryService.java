package com.vnpost.service.impl;

import com.vnpost.converter.CategoryConverter;
import com.vnpost.dto.CategoryDTO;
import com.vnpost.dto.IndexDTO;
import com.vnpost.dto.NewsDTO;
import com.vnpost.entity.CategoryEntity;
import com.vnpost.repository.CategoryRepository;
import com.vnpost.service.ICategoryService;
import com.vnpost.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryConverter categoryConverter;
    @Autowired
    private INewsService newsService;

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream()
                .map(item-> categoryConverter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO findById(Long id) {
        return categoryConverter.convertToDTO(categoryRepository.findById(id).get());
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        if(categoryDTO.getId()==null){
            CategoryEntity categoryEntity = categoryConverter.convertToEntity(categoryDTO);
            return categoryConverter.convertToDTO(categoryRepository.save(categoryEntity));
        }
        return new CategoryDTO();
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        if(categoryDTO.getId()!=null){
            CategoryEntity categoryEntity = categoryConverter.convertToEntity(categoryDTO);
            return categoryConverter.convertToDTO(categoryRepository.save(categoryEntity));
        }
        return new CategoryDTO();
    }

    @Override
    public List<CategoryDTO> findByIdAndStatus(Long id, Integer status) {
        return null;
    }

    @Override
    public IndexDTO findIndexCategory() {
        IndexDTO result = new IndexDTO();
        List<NewsDTO> listNews = newsService.findLatest();
        result.setMostViews(newsService.findMostViews());
        result.setNewsLastest(listNews.get(0));
            for (int i=1;i<4;i++) {
                result.getListOlder().add(listNews.get(i));
            }
        return result;
    }
}
