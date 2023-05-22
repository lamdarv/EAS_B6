package com.ets.lamda.kitchenservice.repository;

//package com.ets.kitchen.repository;

import com.ets.lamda.kitchenservice.model.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitchenRepository extends JpaRepository<Kitchen, Long> {
}
