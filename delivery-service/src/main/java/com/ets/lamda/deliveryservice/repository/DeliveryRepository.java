package com.ets.lamda.deliveryservice.repository;

import com.ets.lamda.deliveryservice.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}

