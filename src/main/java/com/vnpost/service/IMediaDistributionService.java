package com.vnpost.service;

import com.vnpost.dto.MediaDistributionDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMediaDistributionService {
    List<MediaDistributionDTO> findAll();
    List<MediaDistributionDTO> findAll(Pageable pageable);
    MediaDistributionDTO findById(Long id);
    MediaDistributionDTO save(MediaDistributionDTO mediaDistributionDTO);
    MediaDistributionDTO update(MediaDistributionDTO mediaDistributionDTO);
    void deleteOne(Long id);
    Integer count();
}
