package com.tayfint.meethub.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.tayfint.meethub.model.Account;
import com.tayfint.meethub.model.Transaction;

public interface TransactionDao extends CrudRepository<Transaction,Long> {
	
	Page<Transaction> findByAccount(Account acct, Pageable pageRequest);
	
	Page<Transaction> findByAccountAndOriginatorName(Account acct, String originatorName, Pageable pageRequest);
	
	void deleteById(Long id);

}
