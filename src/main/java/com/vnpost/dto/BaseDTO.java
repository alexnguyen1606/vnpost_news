package com.vnpost.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
@Getter
@Setter
public class BaseDTO {
    public BaseDTO (){

    }
    public BaseDTO( Integer page, Integer size,Integer totalPages) {
        this.totalPages = totalPages;
        this.page = page;
        this.size = size;
    }

    public static BaseDTO from(Page<?> pageData) {
        Pageable pageable = pageData.getPageable();
        return new BaseDTO(pageable.getPageNumber() + 1, pageable.getPageSize(), pageData.getTotalPages());
    }

    private Long id;
    private Date createdDate;

    private String createdBy;

    private Date modifiedDate;

    private String modifiedBy;
    private Integer totalPages;
    private Integer page;
    private Integer size;
    private Long[] idDelete = new Long[]{};
    private Long[] listId = new Long[]{};
}
