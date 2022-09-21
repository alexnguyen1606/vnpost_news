package com.vnpost.repository.custom.impl;

import com.vnpost.dto.NewsBuilder;
import com.vnpost.repository.custom.NewsRepositoryCustom;
import com.vnpost.repository.entity.NewsEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@Repository
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class NewsRepositoryCustomImpl implements NewsRepositoryCustom {
    EntityManager entityManager;

    @Override
    public List<NewsEntity> findAll(Map<String, Object> param, NewsBuilder builder, Pageable pageable) {
        StringBuilder sqlSearch = new StringBuilder(" Select * from news as A ");
        String sqlSpecial = buildSqlSpecial(builder);
        if (builder.getCategoryId() != null) {
            sqlSearch.append(" INNER JOIN category as cate ON A.categoryid = cate.id")
                    .append(" WHERE 1=1 ").append(" AND cate.id=").append(builder.getCategoryId())
                    .append(sqlSpecial);
        } else {
            sqlSearch.append(" WHERE 1=1 ");
        }
        sqlSearch = createSqlFindAll(sqlSearch, param);
        System.out.println(sqlSearch);
        Query query = entityManager.createNativeQuery(sqlSearch.toString(), NewsEntity.class);
        query.setMaxResults(pageable.getPageSize());
        query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        return query.getResultList();
    }

    @Override
    public List<NewsEntity> findAll(Map<String, Object> param, NewsBuilder builder) {
        StringBuilder sqlSearch = new StringBuilder(" Select * from news as A ");
        String sqlSpecial = buildSqlSpecial(builder);
        if (builder.getCategoryId() != null) {
            sqlSearch.append(" INNER JOIN category as cate ON A.categoryid = cate.id ")
                    .append(" WHERE 1=1 ")
                    .append(" AND cate.id=").append(builder.getCategoryId());
        } else {
            if (StringUtils.isNotBlank(sqlSpecial)) {
                sqlSearch.append(" , category as cate ");
                sqlSearch.append(" WHERE 1=1 ");
                sqlSearch.append(sqlSpecial);
            } else {
                sqlSearch.append(" WHERE 1=1 ");
            }
        }
        sqlSearch = createSqlFindAll(sqlSearch, param);
        System.out.println(sqlSearch);
        Query query = entityManager.createNativeQuery(sqlSearch.toString(), NewsEntity.class);
        return query.getResultList();
    }

    private String buildSqlSpecial(NewsBuilder fieldSearch) {
        StringBuilder sql = new StringBuilder("");
        if (StringUtils.isNotEmpty(fieldSearch.getCategoryName())) {
            sql.append(" AND cate.name LIKE '%").append(fieldSearch.getCategoryName()).append("%'");
        }
        if (StringUtils.isNotEmpty(fieldSearch.getUrl())) {
            sql.append(" AND cate.url LIKE '%").append(fieldSearch.getCategoryUrl()).append("%'");
        }
        return sql.toString();
    }

    protected StringBuilder createSqlFindAll(StringBuilder where, Map<String, Object> properties) {
        if (isNull(properties)) {
            return where;
        }

        properties.forEach((key, value) -> {
            if (value instanceof String && StringUtils.isNotBlank(value.toString())) {
                where.append(" Or  A.").append(key).append(" LIKE '%").append(value).append("%' ");
            } else if (value instanceof Number) {
                where.append(" AND  A.").append(key).append(" = ").append(value).append(" ");
            }
        });
        return where;
    }
}
