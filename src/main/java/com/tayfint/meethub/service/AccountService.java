package com.tayfint.meethub.service;

import com.tayfint.meethub.model.Membership;
import com.tayfint.meethub.model.PrimaryAccount;
import com.tayfint.meethub.model.SavingsAccount;

public interface AccountService {
	PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();
    void deposit(String accountType, double amount, Membership membership);
    void withdraw(String accountType, double amount, Membership membership);
}
