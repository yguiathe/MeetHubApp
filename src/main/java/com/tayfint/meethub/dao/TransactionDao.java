package com.tayfint.meethub.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.tayfint.meethub.model.Account;
import com.tayfint.meethub.model.Transaction;

public interface TransactionDao extends CrudRepository<Transaction, Long> {

    List<Transaction> findAll();
    
    Page<Transaction> findByAccount(Account acct, Pageable pageRequest);
}

