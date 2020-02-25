package com.vnpost.service.impl;

import com.vnpost.constant.SystemConstant;
import com.vnpost.converter.NewsConverter;
import com.vnpost.converter.ParagraphConverter;
import com.vnpost.dto.NewsDTO;
import com.vnpost.dto.ParagraphDTO;
import com.vnpost.dto.SubcribDTO;
import com.vnpost.entity.NewsEntity;
import com.vnpost.entity.ParagraphEntity;
import com.vnpost.mail.MailService;
import com.vnpost.repository.CategoryRepository;
import com.vnpost.repository.NewsRepository;
import com.vnpost.service.INewsService;
import com.vnpost.service.IParagraphService;
import com.vnpost.service.ISubcribService;
import com.vnpost.sort.NewsSort;
import com.vnpost.utils.FileUtils;
import com.vnpost.utils.UploadFileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NewsService implements INewsService {
    @Autowired
    private ISubcribService subcribService;
    @Autowired
    private IParagraphService paragraphService;
    @Autowired
    private MailService mailService;
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private NewsConverter converter;
    @Autowired
    private ParagraphConverter paragraphConverter;
    @Autowired
    private FileUtils fileUtils;
    @Override
    public List<NewsDTO> findAll(Pageable pageable) {
        return newsRepository.findAll(pageable).getContent()
                .stream().map(item -> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> findAllByStatus(Integer status,Pageable pageable) {
        return newsRepository.findByStatus(status,pageable)
                .stream().map(item-> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> findAllByStatus(Integer status) {
        return newsRepository.findByStatus(status)
                .stream().map(item-> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> findAllByCategoryIdAndStatus(Long subCategoryId, Integer status) {
        return newsRepository.findByCategoryIdAndStatus(subCategoryId,status)
                .stream().map(item-> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> findAllByCategoryIdAndStatus(Long subCategoryId, Integer status, Pageable pageable) {
        return newsRepository.findByCategoryIdAndStatus(subCategoryId,status,pageable)
                .stream().map(item-> converter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public Integer totalItem(Long categoryId) {
        Integer totalItem = findAllByCategoryIdAndStatus(categoryId,SystemConstant.enable).size();
        return totalItem;
    }

    //@Transactional
    @Override
    public NewsDTO save(NewsDTO newsDTO) {
        if (newsDTO.getId()==null){
            try {
                String thumbnail =fileUtils.SaveFile(newsDTO.getThumbnailMultipartFile());
                if (!thumbnail.equals("")){
                    newsDTO.setThumbnail(thumbnail);
                }else {
                    newsDTO.setThumbnail(SystemConstant.THUMBNAIL_PATH);
                }
                NewsEntity newsEntity = converter.convertToEntity(newsDTO);

                newsEntity.setCount(0);
                Long newsId =newsRepository.save(newsEntity).getId();
                paragraphService.saveAll(newsDTO.getListParagraph(),newsId);
                NewsDTO result = findById(newsId);
                for (SubcribDTO subcribDTO:subcribService.findAll()){
                    mailService.sendNewsSubrib(result,subcribDTO);
                }
                return result;
            }catch (Exception e){
                System.out.println(e.toString());
            }
        }
        return new NewsDTO();
    }

    //@Transactional
    @Override
    public NewsDTO update(NewsDTO newsDTO) {
        if (newsDTO.getId()!=null){
            try {
                NewsEntity newsEntityInDb = newsRepository.findById(newsDTO.getId()).get();
                String thumbnail =fileUtils.SaveFile(newsDTO.getThumbnailMultipartFile());
                if (!thumbnail.equals("")){
                    newsDTO.setThumbnail(thumbnail);
                }else {
                    newsDTO.setThumbnail(newsEntityInDb.getThumbnail());
                }
                NewsEntity newsEntity = converter.convertToEntity(newsDTO);
                paragraphService.updateAll(newsDTO.getListParagraph());
                newsEntity.setCount(newsEntityInDb.getCount());
                newsEntity.setCreatedBy(newsEntityInDb.getCreatedBy());
                newsEntity.setCreatedDate(newsEntityInDb.getCreatedDate());
                return converter.convertToDTO(newsRepository.save(newsEntity));
            }catch (Exception e){

            }
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


    //@Transactional
    @Override
    public void enableNews(NewsDTO newsDTO) {
            NewsEntity newsEntity = converter.convertToEntity(newsDTO);
            newsEntity.setStatus(SystemConstant.enable);
            newsRepository.save(newsEntity);
            //update(newsDTO);
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

    //@Transactional
    @Override
    public void disableNews(NewsDTO newsDTO) {
        NewsEntity newsEntity = converter.convertToEntity(newsDTO);
            newsEntity.setStatus(SystemConstant.disable);
            newsRepository.save(newsEntity);
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
        NewsEntity entity = converter.convertToEntity(news);
        entity.setCreatedDate(news.getCreatedDate());
        entity.setCreatedBy(news.getCreatedBy());
        newsRepository.save(entity);
    }

    @Override
    public Boolean exitsById(Long id) {
        return newsRepository.existsById(id);
    }

    @Override
    public List<NewsDTO> findLatest() {
        List<NewsDTO> newsList = newsRepository.findByStatusDesc(SystemConstant.enable)
                .stream().map(item -> converter.convertToDTO(item)).collect(Collectors.toList());

        List<NewsDTO> result = new ArrayList<>();
        if (newsList.size()<=5){
            for (int i=0;i<newsList.size();i++){
                result.add(newsList.get(i));
            }
        }else {
            for (int i=0;i<5;i++){
                result.add(newsList.get(i));
            }
        }

        return result;
    }

    @Override
    public List<NewsDTO> search(String search) {
        return newsRepository.findByNameLike(search)
                .stream().map(item -> converter.convertToDTO((NewsEntity) item)).collect(Collectors.toList());
    }

}
