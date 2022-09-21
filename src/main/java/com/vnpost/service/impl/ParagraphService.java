package com.vnpost.service.impl;

import com.vnpost.converter.ParagraphConverter;
import com.vnpost.dto.ParagraphDTO;
import com.vnpost.repository.entity.ParagraphEntity;
import com.vnpost.repository.ParagraphRepository;
import com.vnpost.service.INewsService;
import com.vnpost.service.IParagraphService;
import com.vnpost.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParagraphService implements IParagraphService {
    @Autowired
    private FileUtils fileUtils;
    @Autowired
    private ParagraphRepository paragraphRepository;
    @Autowired
    private ParagraphConverter converter;
    @Autowired
    private INewsService newsService;

    @Transactional
    @Override
    public ParagraphDTO save(ParagraphDTO paragraphDTO,Long newsId) {
        if (paragraphDTO.getId()==null){
            paragraphDTO.setNews(newsService.findById(newsId));
            ParagraphEntity paragraphEntity = converter.convertToEntity(paragraphDTO);
            return converter.convertToDTO(paragraphRepository.save(paragraphEntity));
        }
        return new ParagraphDTO();
    }

    @Override
    public ParagraphDTO update(ParagraphDTO paragraphDTO) {
        if (paragraphDTO.getId()!=null){
            ParagraphEntity paragraphEntity = converter.convertToEntity(paragraphDTO);
            ParagraphEntity paragraphEntityInDb = paragraphRepository.findById(paragraphEntity.getId()).get();
            paragraphEntity.setCreatedDate(paragraphEntityInDb.getCreatedDate());
            paragraphEntity.setCreatedBy(paragraphEntityInDb.getCreatedBy());
            paragraphEntity.setNews(paragraphEntityInDb.getNews());
            return converter.convertToDTO(paragraphRepository.save(paragraphEntity));
        }
        return new ParagraphDTO();
    }

    @Override
    public ParagraphDTO findById(Long id) {
        return converter.convertToDTO(paragraphRepository.findById(id).get());
    }
}
