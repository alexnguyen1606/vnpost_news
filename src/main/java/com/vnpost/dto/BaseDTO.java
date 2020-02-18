package com.vnpost.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class BaseDTO {
    private Long id;
    private Date createdDate;

    private String createdBy;

    private Date modifiedDate;

    private String modifiedBy;

    private Integer page;
    private Integer limit;
    private Long[] idDelete = new Long[]{};
    private Long[] listId = new Long[]{};
}
