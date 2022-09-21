package com.vnpost.service.impl;

import com.vnpost.converter.SubcribConverter;
import com.vnpost.dto.SubcribDTO;
import com.vnpost.repository.SubcribRepository;
import com.vnpost.repository.entity.SubcribEntity;
import com.vnpost.service.ISubcribService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubcribService implements ISubcribService {
    @Autowired
    private SubcribConverter converter;
    @Autowired
    private SubcribRepository subcribRepository;

    @Override
    public List<SubcribDTO> findAll() {
        return subcribRepository.findAll().stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SubcribDTO save(SubcribDTO subcribDTO) {
        if (subcribDTO.getId() == null) {
            SubcribEntity entity = converter.convertToEntity(subcribDTO);
            return converter.convertToDTO(subcribRepository.save(entity));
        }
        return new SubcribDTO();
    }

    @Override
    public SubcribDTO update(SubcribDTO subcribDTO) {
        if (subcribDTO.getId() != null) {
            SubcribEntity entity = converter.convertToEntity(subcribDTO);
            return converter.convertToDTO(subcribRepository.save(entity));
        }
        return new SubcribDTO();
    }

    @Override
    public void deleteAll(Long[] ids) {
        Arrays.stream(ids).forEach(this::delete);
    }

    @Override
    public void delete(Long id) {
        subcribRepository.deleteById(id);
    }
}
