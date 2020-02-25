package com.vnpost.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class PostageDeliveryDTO extends BaseDTO {

    private String name;

    private String description;

    private String image;

    List<DeliveryServiceDTO> listDeliveryService = new ArrayList<>();
}
