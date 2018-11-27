package com.tayfint.meethub.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.tayfint.meethub.model.SavingsAccount;
import com.tayfint.meethub.model.SavingsTransaction;

public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {

    List<SavingsTransaction> findAll();
    
    List<SavingsTransaction> findBySavingsAccount(SavingsAccount svgAcct, Pageable pageRequest);
}

