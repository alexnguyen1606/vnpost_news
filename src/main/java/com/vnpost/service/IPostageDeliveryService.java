package com.vnpost.service;

import com.vnpost.dto.PostageDeliveryDTO;

import java.util.List;

public interface IPostageDeliveryService {
    List<PostageDeliveryDTO> findAll();
    PostageDeliveryDTO save(PostageDeliveryDTO postageDeliveryDTO);
    PostageDeliveryDTO update(PostageDeliveryDTO postageDeliveryDTO);
    void deleteOne(Long id);

}
