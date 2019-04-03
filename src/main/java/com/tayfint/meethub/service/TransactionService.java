package com.tayfint.meethub.service;

import org.springframework.data.domain.Page;

import com.tayfint.meethub.model.Account;
import com.tayfint.meethub.model.Transaction;

public interface TransactionService {
	Page<Transaction> findTransactionList(Account account, int page);

}
