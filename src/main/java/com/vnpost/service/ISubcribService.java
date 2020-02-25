package com.vnpost.service;

import com.vnpost.dto.SubcribDTO;

import java.util.List;

public interface ISubcribService {
    List<SubcribDTO> findAll();
    SubcribDTO save(SubcribDTO subcribDTO);
    SubcribDTO update(SubcribDTO subcribDTO);
    void deleteAll(Long[] ids);
    void delete(Long id);
}
