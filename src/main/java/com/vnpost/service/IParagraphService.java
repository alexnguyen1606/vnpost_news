package com.vnpost.service;

import com.vnpost.dto.ParagraphDTO;

import java.util.List;

public interface IParagraphService {

    ParagraphDTO save(ParagraphDTO paragraphDTO,Long newsId);
    ParagraphDTO update(ParagraphDTO paragraphDTO);

    ParagraphDTO findById(Long id);

}
