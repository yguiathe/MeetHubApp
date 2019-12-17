package com.tayfint.meethub.service;

import org.springframework.data.domain.Page;
import com.tayfint.meethub.model.Account;
import com.tayfint.meethub.model.Transaction;

public interface TransactionService {

	Page<Transaction> findByAccount(Account acct, int page);
	
	Page<Transaction> findByAccountAndOriginatorName(Account acct, String originatorName, int page);
	
	void deleteById(Long id);

	Transaction save(Transaction transaction);
}
