package com.tayfint.meethub.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.tayfint.meethub.model.Account;

public interface AccountService {

	Account createPrimaryAccount();
    
	Account createSavingsAccount();
    
	Account createLoanAccount();
    
	Account createInvestmentAccount();

	void freeze();

	void delete();

	Account deposit(Account toAccount, BigDecimal amount);

	Account withdraw(Account fromAccount, BigDecimal amount);
    
    Account transfer(String transferFrom, String transferTo, BigDecimal amount, Account fromAccount, Account toAccount);

	void hasSufficientFunds(Account acct);

	List<Account> list();

	void show();

	void getStatement(Account acct);

	void borrow();

	Optional<Account> findById(Long id);
}
