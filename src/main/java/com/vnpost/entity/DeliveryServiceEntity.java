package com.vnpost.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "deliveryservice")
public class DeliveryServiceEntity extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "postagedeliveryid")
    private PostageDeliveryEntity postageDelivery;
    @Column(name = "image")
    private String image;
    @Column(name = "name")
    private String name;//tên dịch vụ

    @Column(name = "shortdescription")
    private String shortDescription;//mô tả ngắng


    @Column(name = "description",columnDefinition = "TEXT")
    private String description;//mô tả dịch vụ

    @Column(name = "servicescope",columnDefinition = "TEXT")
    private String serviceScope;

    @Column(name = "volumndimension",columnDefinition = "TEXT")
    private String volumnDimension;

    @Column(name = "complaincompension",columnDefinition = "TEXT")
    private String complainCompension;

    @Column(name = "rates",columnDefinition = "TEXT")
    private String rates;

    @Column(name = "specialservice",columnDefinition = "TEXT")
    private String specialService;

    @Column(name = "exportprocedure",columnDefinition = "TEXT")
    private String exportProcedure;//xuất khẩu

    @Column(name = "timelimit",columnDefinition = "TEXT")
    private String timeLimit;//chỉ tiêu thời gian

    @Column(name = "extraservice",columnDefinition = "TEXT")
    private String extraService;//dịch vụ cộng thêm

    @Column(name = "shippingmethod",columnDefinition = "TEXT")
    private String shippingMethod;

    @Column(name = "conditionalapproval",columnDefinition = "TEXT")
    private String conditionalApproval;
}
