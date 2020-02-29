package com.vnpost.dto;

import lombok.Getter;
import lombok.Setter;

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
