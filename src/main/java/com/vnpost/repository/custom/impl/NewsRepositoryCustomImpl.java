package com.vnpost.repository.custom.impl;

import com.vnpost.entity.NewsEntity;
import com.vnpost.repository.custom.NewsRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class NewsRepositoryCustomImpl implements NewsRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<NewsEntity> findLatestByCategoryId(Long categoryId) {
        String sql = "select n from NewsEntity as n where n.category.id=:categoryId order by n.createdDate desc ";

        Query query = entityManager.createQuery(sql);
        query.setParameter("categoryId",categoryId);
        return query.setMaxResults(5).getResultList();
    }



}
