package com.tayfint.meethub.service;

import com.tayfint.meethub.model.Membership;
import com.tayfint.meethub.model.PrimaryAccount;
import com.tayfint.meethub.model.SavingsAccount;
import com.tayfint.meethub.model.dto.DepositWithdrawDTO;

public interface AccountService {
	PrimaryAccount createPrimaryAccount();
    SavingsAccount createSavingsAccount();
    DepositWithdrawDTO deposit(String accountType, double amount, Membership membership);
    DepositWithdrawDTO withdraw(String accountType, double amount, Membership membership);
}
