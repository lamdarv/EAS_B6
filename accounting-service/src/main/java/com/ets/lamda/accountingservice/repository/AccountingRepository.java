package com.ets.lamda.accountingservice.repository;


import com.ets.lamda.accountingservice.model.Accounting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountingRepository extends JpaRepository<Accounting, String> {
    List<Accounting> findByUsername(String username);
}
