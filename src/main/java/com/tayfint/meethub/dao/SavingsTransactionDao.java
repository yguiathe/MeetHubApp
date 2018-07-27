package com.tayfint.meethub.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tayfint.meethub.model.SavingsTransaction;

@Repository
public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {

    List<SavingsTransaction> findAll();
}

