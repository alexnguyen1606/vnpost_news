package com.vnpost.repository;

import com.vnpost.repository.entity.PostageDeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostageDeliveryRepository extends JpaRepository<PostageDeliveryEntity,Long> {
}
