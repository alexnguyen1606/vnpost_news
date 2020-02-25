package com.vnpost.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Table(name = "postagedelivery")
@Entity
public class PostageDeliveryEntity extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "description",columnDefinition = "TEXT")
    private String description;
    @Column(name = "image")
    private String image;
    @OneToMany(mappedBy = "postageDelivery",fetch = FetchType.EAGER)
    List<DeliveryServiceEntity> listDeliveryService = new ArrayList<>();
}
