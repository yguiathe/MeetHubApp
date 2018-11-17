package com.tayfint.meethub.service;

import com.tayfint.meethub.model.Account;
import com.tayfint.meethub.model.Membership;
import com.tayfint.meethub.model.PrimaryAccount;
import com.tayfint.meethub.model.SavingsAccount;

public interface AccountService {
	PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();
    Account deposit(String accountType, double amount, Membership membership);
    Account withdraw(String accountType, double amount, Membership membership);
}
