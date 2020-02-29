package com.vnpost.service;

import com.vnpost.dto.DeliveryServiceDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDeliveryService {
    List<DeliveryServiceDTO> findByPostageDeliveryId(Long id);
    List<DeliveryServiceDTO> findByPostageDeliveryId(Long id,Pageable pageable);
    DeliveryServiceDTO findById(Long id);
    DeliveryServiceDTO save(DeliveryServiceDTO deliveryServiceDTO);
    DeliveryServiceDTO update(DeliveryServiceDTO deliveryServiceDTO);
    void deleteOne(Long id);
    List<DeliveryServiceDTO> findAll(Pageable pageable);
    Long count();
    Integer countByPostId(Long id);
}
