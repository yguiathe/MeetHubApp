package com.tayfint.meethub.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tayfint.meethub.dao.TransactionDao;
import com.tayfint.meethub.model.Account;
import com.tayfint.meethub.model.Transaction;

@Service("transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao transactionDao;

	static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	public Page<Transaction> findTransactionList(Account account, int page) {
		Page<Transaction> transactionList = transactionDao.findByAccount(account,
				new PageRequest(page, 10, Sort.Direction.DESC, "date"));
		logger.debug("****************** Number of Transactions is: " + transactionList.getTotalPages());

		return transactionList;
	}

}
