package com.vnpost.repository;

import com.vnpost.repository.entity.DeliveryServiceEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryServiceRepository extends JpaRepository<DeliveryServiceEntity,Long> {
    List<DeliveryServiceEntity> findByPostageDeliveryId(Long id);
    List<DeliveryServiceEntity> findByPostageDeliveryId(Long id, Pageable pageable);
    Long countDeliveryServiceEntitiesByPostageDeliveryId(Long id);
}
