package com.vnpost.service.impl;

import com.vnpost.converter.ParagraphConverter;
import com.vnpost.dto.ParagraphDTO;
import com.vnpost.entity.ParagraphEntity;
import com.vnpost.repository.ParagraphRepository;
import com.vnpost.service.INewsService;
import com.vnpost.service.IParagraphService;
import com.vnpost.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    @Override
    public List<ParagraphDTO> findByNewsId(Long newsId) {
        return paragraphRepository.findByNewsId(newsId).stream()
                .map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }
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
    public ParagraphDTO update(ParagraphDTO paragraphDTO, Long newsId) {
        if (paragraphDTO.getId()!=null){
            ParagraphEntity paragraphEntity = converter.convertToEntity(paragraphDTO);
            ParagraphEntity paragraphEntityInDb = paragraphRepository.findById(paragraphEntity.getId()).get();
            paragraphEntity.setCreatedDate(paragraphEntityInDb.getCreatedDate());
            paragraphEntity.setCreatedBy(paragraphEntityInDb.getCreatedBy());
            return converter.convertToDTO(paragraphRepository.save(paragraphEntity));
        }
        return new ParagraphDTO();
    }

    @Override
    public void saveAll(List<ParagraphDTO> paragraphs,Long newsId) {
        for(ParagraphDTO paragraph : paragraphs){
            String imagePath=fileUtils.SaveFile(paragraph.getMultipartFile());
            if (!imagePath.equals("")){
                paragraph.setImage(imagePath);
            }
            save(paragraph,newsId);
        }
    }

    @Override
    public void updateAll(List<ParagraphDTO> paragraphList, Long newsId) {
        for (ParagraphDTO paragraph : paragraphList){
            String imagePath = fileUtils.SaveFile(paragraph.getMultipartFile());
            if (!imagePath.equals("")){
                paragraph.setImage(imagePath);
            }
            update(paragraph,newsId);
        }
    }
}
