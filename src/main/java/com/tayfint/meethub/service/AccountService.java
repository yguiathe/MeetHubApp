package com.tayfint.meethub.service;

import java.math.BigDecimal;

import com.tayfint.meethub.model.Account;

public interface AccountService {
	Account createPrimaryAccount();
    Account createSavingsAccount();
    Account createLoanAccount();
    Account createInvestmentAccount();
    
    Account deposit(Account toAccount, BigDecimal amount);

	Account withdraw(Account fromAccount, BigDecimal amount);
    
    Account transfer(String transferFrom, String transferTo, BigDecimal amount, Account fromAccount, Account toAccount);
    
    Account findById(Long id);
}
