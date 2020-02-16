package com.vnpost.service;

import com.vnpost.dto.ParagraphDTO;

import java.util.List;

public interface IParagraphService {
    List<ParagraphDTO> findByNewsId(Long newsId);
    ParagraphDTO save(ParagraphDTO paragraphDTO);
    void saveAll(List<ParagraphDTO> paragraphs);

}
