package com.vnpost.service.impl;

import com.vnpost.converter.NewsConverter;
import com.vnpost.converter.ParagraphConverter;
import com.vnpost.dto.NewsBuilder;
import com.vnpost.dto.NewsDTO;
import com.vnpost.repository.CategoryRepository;
import com.vnpost.repository.NewsRepository;
import com.vnpost.repository.entity.NewsEntity;
import com.vnpost.service.INewsService;
import com.vnpost.service.IParagraphService;
import com.vnpost.service.ISubcribService;
import com.vnpost.service.MailService;
import com.vnpost.utils.FileUtils;
import com.vnpost.utils.constant.SystemConstant;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NewsService implements INewsService {

    ISubcribService subcribService;
    IParagraphService paragraphService;
    MailService mailService;
    NewsRepository newsRepository;
    CategoryRepository categoryRepository;
    NewsConverter converter;
    ParagraphConverter paragraphConverter;

    ExecutorService executorService = Executors.newFixedThreadPool(5);

    FileUtils fileUtils;

    @Override
    public List<NewsDTO> findAll(Pageable pageable) {
        return newsRepository.findAll(pageable).getContent()
                .stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> findAll() {
        return newsRepository.findAll()
                .stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> findAllByStatus(Integer status, Pageable pageable) {
        return newsRepository.findByStatus(status, pageable)
                .stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> findAllByStatus(Integer status) {
        return newsRepository.findByStatus(status)
                .stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> findAllByCategoryIdAndStatus(Long subCategoryId, Integer status) {
        return newsRepository.findByCategoryIdAndStatus(subCategoryId, status)
                .stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> findAllByCategoryIdAndStatus(Long subCategoryId, Integer status, Pageable pageable) {
        return newsRepository.findByCategoryIdAndStatus(subCategoryId, status, pageable)
                .stream().map(converter::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Integer totalItem(Long categoryId) {
        return findAllByCategoryIdAndStatus(categoryId, SystemConstant.enable).size();
    }

    //@Transactional
    @Override
    public NewsDTO save(NewsDTO newsDTO) {
        if (newsDTO.getId() == null) {
            try {
                NewsEntity newsEntity = converter.convertToEntity(newsDTO);

                newsEntity.setCount(0);
                Long newsId = newsRepository.save(newsEntity).getId();
                NewsDTO result = findById(newsId);
                subcribService.findAll()
                        .forEach(item -> executorService.execute(() -> {
                            mailService.sendNewsSubrib(result, item);
                        }));

                return result;
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return new NewsDTO();
    }

    //@Transactional
    @Override
    public NewsDTO update(NewsDTO newsDTO) {
        if (newsDTO.getId() != null) {
            try {
                NewsEntity newsEntityInDb = newsRepository.findById(newsDTO.getId()).get();
                String thumbnail = fileUtils.SaveFile(newsDTO.getThumbnailMultipartFile());
//                if (!thumbnail.equals("")){
//                    newsDTO.setThumbnail(thumbnail);
//                }else {
//                    newsDTO.setThumbnail(newsEntityInDb.getThumbnail());
//                }
                NewsEntity newsEntity = converter.convertToEntity(newsDTO);
                newsEntity.setCount(newsEntityInDb.getCount());
                newsEntity.setCreatedBy(newsEntityInDb.getCreatedBy());
                newsEntity.setCreatedDate(newsEntityInDb.getCreatedDate());
                return converter.convertToDTO(newsRepository.save(newsEntity));
            } catch (Exception e) {

            }
        }
        return new NewsDTO();
    }

    @Override
    public NewsDTO findById(Long id) {
        return converter.convertToDTO(newsRepository.findById(id).get());
    }

    @Override
    public NewsDTO findByIdAndStatus(Long id, Integer status) {
        return converter.convertToDTO(newsRepository.findByIdAndStatus(id, status));
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
        Arrays.stream(ids).parallel()
                .map(this::findById)
                .forEach(this::disableNews);
    }

    @Override
    public void enableAll(Long[] ids) {
        Arrays.stream(ids).parallel()
                .map(this::findById)
                .forEach(this::enableNews);
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
        Arrays.asList(ids).forEach(this::deleteOne);
    }

    @Override
    @Transactional
    public void deleteOne(Long id) {
        newsRepository.deleteById(id);
    }

    @Override
    public NewsDTO findMostViewsByCategoryId(Long id) {
        List<NewsDTO> listNews = findAllByCategoryIdAndStatus(id, SystemConstant.enable);
        NewsDTO maxView = listNews.get(0);
        for (NewsDTO item : listNews) {
            if (item.getCount() >= maxView.getCount()) {
                maxView = item;
            }
        }
        return maxView;
    }

    @Override
    public NewsDTO findMostViews() {
        return converter.convertToDTO(newsRepository.findFirstOrderByCountOnDesc());
    }

    @Override
    public void countViews(Long id) {
        NewsEntity entity = newsRepository.findById(id).orElseThrow(RuntimeException::new);
        entity.incrementView();
        newsRepository.save(entity);
    }

    @Override
    public Boolean exitsById(Long id) {
        return newsRepository.existsById(id);
    }

    @Override
    public List<NewsDTO> findLatest() {
        return newsRepository.findByStatusDesc(SystemConstant.enable)
                .stream()
                .map(converter::convertToDTO)
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> search(NewsBuilder builder) {
        Map<String, Object> properties = convertToMapProperties(builder);
        return newsRepository.findAll(properties, builder)
                .stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> search(NewsBuilder builder, Pageable pageable) {
        Map<String, Object> properties = convertToMapProperties(builder);
        return newsRepository.findAll(properties, builder, pageable)
                .stream().map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<NewsDTO> searchByAdmin(NewsDTO newsDTO, Pageable pageable) {
        NewsBuilder builder = NewsBuilder.builder()
                .author(newsDTO.getAuthor())
                .name(newsDTO.getName())
                .categoryId(newsDTO.getCateId())
                .status(newsDTO.getStatus())
                .build();
        Map<String, Object> properties = convertToMapProperties(builder);

        return newsRepository.findAll(properties, builder, pageable)
                .stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    Map<String, Object> convertToMapProperties(NewsBuilder fieldSearch) {
        Map<String, Object> properties = new HashMap<>();
        try {
            Field[] fields = NewsBuilder.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object valueField = field.get(fieldSearch);
                if (isNull(valueField)) {
                    continue;
                }

                if (field.getName().equals(NewsBuilder.Fields.categoryId)
                        || field.getName().equals(NewsBuilder.Fields.categoryName)
                        || field.getName().equals(NewsBuilder.Fields.categoryUrl)) {
                    continue;
                }
                properties.put(field.getName().toLowerCase(), valueField);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return properties;
    }


}
