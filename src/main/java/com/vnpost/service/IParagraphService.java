package com.vnpost.service;

import com.vnpost.dto.ParagraphDTO;

import java.util.List;

public interface IParagraphService {
    List<ParagraphDTO> findByNewsId(Long newsId);
    ParagraphDTO save(ParagraphDTO paragraphDTO,Long newsId);
    ParagraphDTO update(ParagraphDTO paragraphDTO,Long newsId);
    void saveAll(List<ParagraphDTO> paragraphsd,Long newsId);
    void updateAll(List<ParagraphDTO> paragraphList,Long newsId);

}
