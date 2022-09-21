package com.vnpost.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "postagefinace")
@Entity
public class PostageFinaceEntity extends BaseEntity {
    @Column(name = "name")
    private String name;//tên dịch vụ
    @Column(name = "image")
    private String image;//ảnh
    @Column(name = "shortdescription",columnDefinition = "TEXT")
    private String shortDescription;//mô tả ngắng
    @Column(name = "content",columnDefinition = "TEXT")
    private String content;
//    @Column(name = "description",columnDefinition = "TEXT")
//    private String description;//mô tả dịch vụ
//
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
//
//
//    @Column(name = "promotion",columnDefinition = "TEXT")
//    private String promotion;
//
//
//    @Column(name = "servicespecification",columnDefinition = "TEXT")
//    private String serviceSpecification;
//
//    @Column(name = "extraservice",columnDefinition = "TEXT")
//    private String extraService;//dịch vụ cộng thêm
//
//
//    @Column(name = "targetsaving",columnDefinition = "TEXT")
//    private String targetSaving;//đối tượng tiết kiệm
//
//    @Column(name = "interestrate",columnDefinition = "TEXT")
//    private String interestRate;//Lãi xuất
//
//    @Column(name = "servicebenefit",columnDefinition = "TEXT")
//    private String serviceBenefit;//lợi ích dịch vụ
}
