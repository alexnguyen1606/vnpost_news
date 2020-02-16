package com.vnpost.service.impl;

import com.vnpost.converter.NewsConverter;
import com.vnpost.dto.NewsDTO;
import com.vnpost.entity.NewsEntity;
import com.vnpost.repository.NewsRepository;
import com.vnpost.service.INewsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService implements INewsService {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private NewsConverter converter;
    @Override
    public List<NewsDTO> findAll() {
        return newsRepository.findAll()
                .stream().map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> findAllBySubCategoryId(Long subCategoryId) {

        return newsRepository.findAllBySubCategoryId(subCategoryId)
                .stream().map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> findAllByStatus(Integer status) {
        return newsRepository.findAllByStatus(status)
                .stream().map(item-> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> findAllBySubCategoryIdAndStatus(Long subCategoryId, Integer status) {
        return newsRepository.findAllBySubCategoryIdAndStatus(subCategoryId,status)
                .stream().map(item-> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public NewsDTO save(NewsDTO newsDTO) {
        if (newsDTO.getId()==null){
            NewsEntity newsEntity = converter.convertToEntity(newsDTO);
            return converter.convertToDTO(newsRepository.save(newsEntity));
        }
        return new NewsDTO();
    }

    @Override
    public NewsDTO update(NewsDTO newsDTO) {
        if (newsDTO.getId()!=null){
            NewsEntity newsEntity = converter.convertToEntity(newsDTO);
            return converter.convertToDTO(newsRepository.save(newsEntity));
        }
        return new NewsDTO();
    }

    @Override
    public NewsDTO findById(Long id) {
        if(id!=null){
            return converter.convertToDTO(newsRepository.findById(id));
        }
        return new NewsDTO();
    }

    @Override
    public NewsDTO findByUrl(String url) {
        if ((Boolean) StringUtils.isNotEmpty(url)){
            return converter.convertToDTO(newsRepository.findByUrl(url));
        }
        return new NewsDTO();
    }

    @Override
    public void disable(NewsDTO newsDTO) {
        if (newsDTO.getId()!=null){
            NewsEntity newsEntity = converter.convertToEntity(newsDTO);
            newsEntity.setStatus(1);
            newsRepository.save(newsEntity);
        }
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids){
            deleteOne(id);
        }
    }

    @Override
    public void deleteOne(Long id) {
        if (id!=null){
            newsRepository.deleteById(id);
        }
    }
}
