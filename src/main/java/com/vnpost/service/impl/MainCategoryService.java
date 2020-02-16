package com.vnpost.service.impl;

import com.vnpost.converter.MainCategoryConverter;
import com.vnpost.dto.MainCategoryDTO;
import com.vnpost.entity.MainCategoryEntity;
import com.vnpost.repository.MainCategoryRepository;
import com.vnpost.service.IMainCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainCategoryService implements IMainCategoryService {
    @Autowired
    private MainCategoryRepository mainCategoryRepository;
    @Autowired
    private MainCategoryConverter converter;
    @Override
    public List<MainCategoryDTO> findAll() {
        return mainCategoryRepository.findAll()
                .stream().map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public MainCategoryDTO save(MainCategoryDTO mainCategoryDTO) {
        if (mainCategoryDTO.getId()==null){
            MainCategoryEntity mainCategoryEntity = converter.convertToEntity(mainCategoryDTO);
            return converter.convertToDTO(mainCategoryRepository.save(mainCategoryEntity));
        }
        return new MainCategoryDTO();
    }

    @Override
    public MainCategoryDTO update(MainCategoryDTO mainCategoryDTO) {
        if(mainCategoryDTO.getId()!=null){
            MainCategoryEntity mainCategoryEntity = converter.convertToEntity(mainCategoryDTO);
            return converter.convertToDTO(mainCategoryRepository.save(mainCategoryEntity));
        }
        return new MainCategoryDTO();
    }

    @Override
    public void deleteOne(Long id) {
        if (findById(id).getId()!=null){
            mainCategoryRepository.deleteById(id);
        }
    }

    @Override
    public MainCategoryDTO findByUrl(String url) {
        return converter.convertToDTO(findByUrl(url));
    }

    @Override
    public MainCategoryDTO findById(Long id) {
        if (id!=null){
            return converter.convertToDTO(mainCategoryRepository.findById(id));
        }
        return new MainCategoryDTO();
    }
}
