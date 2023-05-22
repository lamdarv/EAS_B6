package com.ets.lamda.consumerservice.repository;

import com.ets.lamda.consumerservice.model.Consumer;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

}
