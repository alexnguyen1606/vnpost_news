package com.vnpost.service.impl;

import com.vnpost.converter.ParagraphConverter;
import com.vnpost.dto.ParagraphDTO;
import com.vnpost.entity.ParagraphEntity;
import com.vnpost.repository.ParagraphRepository;
import com.vnpost.service.IParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParagraphService implements IParagraphService {
    @Autowired
    private ParagraphRepository paragraphRepository;
    @Autowired
    private ParagraphConverter converter;
    @Override
    public List<ParagraphDTO> findByNewsId(Long newsId) {
        return paragraphRepository.findByNewsId(newsId).stream()
                .map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }
    @Transactional
    @Override
    public ParagraphDTO save(ParagraphDTO paragraphDTO) {
        if (paragraphDTO.getId()==null){
            ParagraphEntity paragraphEntity = converter.convertToEntity(paragraphDTO);
            return converter.convertToDTO(paragraphRepository.save(paragraphEntity));

        }
        return new ParagraphDTO();
    }

    @Override
    public void saveAll(List<ParagraphDTO> paragraphs) {
        for(ParagraphDTO paragraph : paragraphs){
            save(paragraph);
        }
    }
}
