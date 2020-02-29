package com.vnpost.repository.custom.impl;

import com.vnpost.builder.NewsBuilder;
import com.vnpost.entity.NewsEntity;
import com.vnpost.repository.custom.NewsRepositoryCustom;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
@Repository
public class NewsRepositoryImpl implements NewsRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<NewsEntity> findAll(Map<String, Object> param, NewsBuilder builder, Pageable pageable) {
        StringBuilder sqlSearch = new StringBuilder(" Select * from news as A ");
        String sqlSpecial =buildSqlSpecial(builder);
        if (builder.getCategoryId()!=null){
            sqlSearch.append(" INNER JOIN category as cate ON A.categoryid = cate.id");
            sqlSearch.append(" WHERE 1=1 ");
            sqlSearch.append(" AND cate.id="+builder.getCategoryId());
            sqlSearch.append(sqlSpecial);
        }else {
            sqlSearch.append(" WHERE 1=1 ");
        }
        sqlSearch = createSqlFindAll(sqlSearch,param);
        System.out.println(sqlSearch);
        Query query =entityManager.createNativeQuery(sqlSearch.toString(),NewsEntity.class);
        query.setMaxResults(pageable.getPageSize());
        query.setFirstResult(pageable.getPageNumber()*pageable.getPageSize());
        return query.getResultList();
    }

    @Override
    public List<NewsEntity> findAll(Map<String, Object> param, NewsBuilder builder) {
        StringBuilder sqlSearch = new StringBuilder(" Select * from news as A ");
        String sqlSpecial =buildSqlSpecial(builder);
        if (builder.getCategoryId()!=null){
            sqlSearch.append(" INNER JOIN category as cate ON A.categoryid = cate.id ");
            sqlSearch.append(" WHERE 1=1 ");
            sqlSearch.append(" AND cate.id="+builder.getCategoryId());
        }else {
            if (sqlSearch!=null && StringUtils.isNotBlank(sqlSpecial)){
                sqlSearch.append(" , category as cate ");
                sqlSearch.append(" WHERE 1=1 ");
                sqlSearch.append(sqlSpecial);
            }else {
                sqlSearch.append(" WHERE 1=1 ");
            }
        }
        sqlSearch = createSqlFindAll(sqlSearch,param);
        System.out.println(sqlSearch);
        Query query =entityManager.createNativeQuery(sqlSearch.toString(),NewsEntity.class);
        return query.getResultList();
    }
    private String buildSqlSpecial(NewsBuilder fieldSearch) {
        StringBuilder sql = new StringBuilder("");
        if (StringUtils.isNotEmpty(fieldSearch.getCategoryName())){
            sql.append(" AND cate.name LIKE '%"+fieldSearch.getCategoryName()+"%'");
        }
        if (StringUtils.isNotEmpty(fieldSearch.getUrl())){
            sql.append(" AND cate.url LIKE '%"+fieldSearch.getCategoryUrl()+"%'");
        }
        return sql.toString();
    }

    protected StringBuilder createSqlFindAll(StringBuilder where,Map<String,Object> properties) {
        if(properties!=null && properties.size()>0){
            String[] keys = new String[properties.size()];
            Object[] values = new Object[properties.size()];
            int i=0;
            for(Map.Entry<String,Object> entry : properties.entrySet()){
                keys[i]=entry.getKey();
                values[i] = entry.getValue();
                i++;
            }
            for (int i1=0 ;i1 <keys.length;i1++ ){
                if (values[i1] instanceof String && StringUtils.isNotBlank(values[i1].toString())){
                    where.append(" Or  A."+keys[i1]+" LIKE '%"+values[i1].toString()+"%' ");
                }else if(values[i1] instanceof Integer && values[i1]!=null){
                    where.append(" AND  A."+keys[i1]+" = "+values[i1]+" ");

                } else if (values[i1] instanceof Long && values[i1]!=null){
                    where.append(" Or  A."+keys[i1]+" = "+values[i1]+" ");
                }
            }
        }
        return where;
    }
}
