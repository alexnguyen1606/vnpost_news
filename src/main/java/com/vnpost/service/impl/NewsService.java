package com.vnpost.service.impl;

import com.vnpost.constant.SystemConstant;
import com.vnpost.converter.NewsConverter;
import com.vnpost.dto.NewsDTO;
import com.vnpost.entity.NewsEntity;
import com.vnpost.repository.NewsRepository;
import com.vnpost.service.INewsService;
import com.vnpost.sort.NewsSort;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

//    @Override
//    public List<NewsDTO> findAllByCategoryId(Long categoryId) {
//        return newsRepository.findAllByCategoryId(categoryId).stream()
//                .map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
//    }


    @Override
    public List<NewsDTO> findAllByStatus(Integer status) {
        return newsRepository.findAllByStatus(status)
                .stream().map(item-> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> findAllByCategoryIdAndStatus(Long subCategoryId, Integer status) {
        return newsRepository.findAllByCategoryIdAndStatus(subCategoryId,status)
                .stream().map(item-> converter.convertToDTO(item)).collect(Collectors.toList());
    }
    @Transactional
    @Override
    public NewsDTO save(NewsDTO newsDTO) {
        if (newsDTO.getId()==null){
            NewsEntity newsEntity = converter.convertToEntity(newsDTO);
            return converter.convertToDTO(newsRepository.save(newsEntity));
        }
        return new NewsDTO();
    }

    @Transactional
    @Override
    public NewsDTO update(NewsDTO newsDTO) {
        if (newsDTO.getId()!=null){
            NewsEntity newsEntity = converter.convertToEntity(newsDTO);
            NewsEntity newsEntityInDb = newsRepository.findById(newsEntity.getId()).get();
            newsEntity.setCreatedBy(newsEntityInDb.getCreatedBy());
            newsEntity.setCreatedDate(newsEntityInDb.getCreatedDate());
            return converter.convertToDTO(newsRepository.save(newsEntity));
        }
        return new NewsDTO();
    }

    @Override
    public NewsDTO findById(Long id) {
        if(exitsById(id)){
            return converter.convertToDTO(newsRepository.findById(id).get());
        }
        return new NewsDTO();
    }

//    @Override
//    public NewsDTO findByUrl(String url) {
//        if ((Boolean) StringUtils.isNotEmpty(url)){
//            return converter.convertToDTO(newsRepository.findByUrl(url));
//        }
//        return new NewsDTO();
//    }
    @Transactional
    @Override
    public void enableNews(NewsDTO newsDTO) {
//            NewsEntity newsEntity = converter.convertToEntity(newsDTO);
//            newsEntity.setStatus(SystemConstant.enable);
//            newsRepository.save(newsEntity);
        newsDTO.setStatus(SystemConstant.enable);
        update(newsDTO);
    }

    @Override
    public void disableAll(Long[] ids) {
        for(Long id : ids){
            disableNews(findById(id));
        }
    }

    @Override
    public void enableAll(Long[] ids) {
        for (Long id : ids){
            enableNews(findById(id));
        }
    }

    @Transactional
    @Override
    public void disableNews(NewsDTO newsDTO) {
//            NewsEntity newsEntity = converter.convertToEntity(newsDTO);
//            newsEntity.setStatus(SystemConstant.disable);
//            newsRepository.save(newsEntity);
            newsDTO.setStatus(SystemConstant.disable);
            update(newsDTO);
    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids){
            deleteOne(id);
        }
    }

    @Override
    @Transactional
    public void deleteOne(Long id) {
        if (id!=null && exitsById(id)){
            newsRepository.deleteById(id);
        }
    }

    @Override
    public NewsDTO findMostViewsByCategoryId(Long id) {
        List<NewsDTO> listNews = findAllByCategoryIdAndStatus(id, SystemConstant.enable);
        NewsDTO maxView = listNews.get(0);
        for (NewsDTO item : listNews)
        {
            if (item.getCount() >= maxView.getCount() ){
                maxView = item;
            }
        }
        return maxView;
    }

    @Override
    public NewsDTO findMostViews() {
        List<NewsDTO> listNews = findAllByStatus(SystemConstant.enable);
        NewsDTO maxView = listNews.get(0);
        for (NewsDTO item : listNews)
        {
            if (item.getCount() >= maxView.getCount() ){
                maxView = item;
            }
        }
        return maxView;
    }

    @Override
    public void countViews(Long id) {
        NewsDTO news = findById(id);
        if (news.getCount()==0 || news.getCount()==null){
            news.setCount(1);
        }else {
            news.setCount(news.getCount()+1);
        }
        update(news);
    }

    @Override
    public Boolean exitsById(Long id) {
        return newsRepository.existsById(id);
    }

    @Override
    public List<NewsDTO> findLatest() {
        List<NewsDTO> result = findAllByStatus(SystemConstant.enable);
        Collections.sort(result, new Comparator<NewsDTO>() {
            @Override
            public int compare(NewsDTO o1, NewsDTO o2) {
                return o1.getCreatedDate().compareTo(o2.getCreatedDate());
            }
        });
        Collections.reverse(result);
        return result;
    }

}
