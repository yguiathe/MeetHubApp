package com.tayfint.meethub.service;

import java.security.Principal;

import com.tayfint.meethub.model.Meeting;
import com.tayfint.meethub.model.PrimaryAccount;
import com.tayfint.meethub.model.SavingsAccount;

public interface AccountService {
	PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();
    void deposit(String accountType, double amount, Meeting meeting, Principal principal);
    void withdraw(String accountType, double amount, Meeting meeting, Principal principal);
}
