package com.tayfint.meethub.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.tayfint.meethub.model.PrimaryAccount;
import com.tayfint.meethub.model.PrimaryTransaction;

public interface PrimaryTransactionDao extends PagingAndSortingRepository<PrimaryTransaction, Long> {

    List<PrimaryTransaction> findAll();
    
    List<PrimaryTransaction> findByPrimaryAccount(PrimaryAccount primaryAcct);
}
