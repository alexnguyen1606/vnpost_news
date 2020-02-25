package com.vnpost.service;

import com.vnpost.dto.ParagraphDTO;

import java.util.List;

public interface IParagraphService {
    List<ParagraphDTO> findByNewsId(Long newsId);
    ParagraphDTO save(ParagraphDTO paragraphDTO,Long newsId);
    ParagraphDTO update(ParagraphDTO paragraphDTO);
    void saveAll(List<ParagraphDTO> paragraphsd,Long newsId);
    void updateAll(List<ParagraphDTO> paragraphList);
    ParagraphDTO findById(Long id);

}
