package com.vnpost.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mediadistribution")
@Setter@Getter
public class MediaDistributionEntity extends BaseEntity {
    @Column(name = "name")
    private String name;//tên dịch vụ
    @Column(name = "image")
    private String image;//ảnh
    @Column(name = "shortdescription",columnDefinition = "TEXT")
    private String shortDescription;//mô tả ngắng
    @Column(name = "content",columnDefinition = "TEXT")
    private String content;
//    @Column(name = "servicescope",columnDefinition = "TEXT")
//    private String serviceScope;
//
//
//    @Column(name = "rates",columnDefinition = "TEXT")
//    private String rates;
//
//
//    @Column(name = "popularquestion",columnDefinition = "TEXT")
//    private String popularQuestion;
//    @Column(name = "servicespecification",columnDefinition = "TEXT")
//    private String serviceSpecification;
//    @Column(name = "supplyindustry",columnDefinition = "TEXT")
//    private String supplyIndustry;
}
