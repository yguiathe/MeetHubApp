package com.tayfint.meethub.service;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayfint.meethub.dao.PrimaryAccountDao;
import com.tayfint.meethub.dao.SavingsAccountDao;
import com.tayfint.meethub.model.Membership;
import com.tayfint.meethub.model.PrimaryAccount;
import com.tayfint.meethub.model.PrimaryTransaction;
import com.tayfint.meethub.model.SavingsAccount;
import com.tayfint.meethub.model.SavingsTransaction;
import com.tayfint.meethub.model.dto.DepositWithdrawDTO;

@Service
public class AccountServiceImpl implements AccountService {
	
	private static int nextAccountNumber = 1000000;

    @Autowired
    private PrimaryAccountDao primaryAccountDao;

    @Autowired
    private SavingsAccountDao savingsAccountDao;

    @Autowired
    private TransactionService transactionService;
    
    static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    public PrimaryAccount createPrimaryAccount() {
        PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountBalance(new BigDecimal(0.0));
        primaryAccount.setAccountNumber(accountGen());

        primaryAccountDao.save(primaryAccount);

        return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
    }

    public SavingsAccount createSavingsAccount() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountBalance(new BigDecimal(0.0));
        savingsAccount.setAccountNumber(accountGen());

        savingsAccountDao.save(savingsAccount);

        return savingsAccountDao.findByAccountNumber(savingsAccount.getAccountNumber());
    }
    
    public DepositWithdrawDTO deposit(String accountType, double amount, Membership membership) {
    	DepositWithdrawDTO dto = new DepositWithdrawDTO();
    	dto.setOperationType("Deposit");
    	dto.setAccountType(accountType);
        if (accountType.equalsIgnoreCase("Primary")) {
            PrimaryAccount primaryAccount = membership.getPrimaryAccount();
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));
            primaryAccountDao.save(primaryAccount);

            Date date = new Date();

            PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Deposit to Primary Account", "DEP", "Finished", amount, primaryAccount.getAccountBalance(), primaryAccount);
            transactionService.savePrimaryDepositTransaction(primaryTransaction);
            
            dto.setAmount(primaryAccount.getAccountBalance());
            
        } else if (accountType.equalsIgnoreCase("Savings")) {
            SavingsAccount savingsAccount = membership.getSavingsAccount();
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().add(new BigDecimal(amount)));
            savingsAccountDao.save(savingsAccount);

            Date date = new Date();
            SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Deposit to savings Account", "DEP", "Finished", amount, savingsAccount.getAccountBalance(), savingsAccount);
            transactionService.saveSavingsDepositTransaction(savingsTransaction);
            dto.setAmount(savingsAccount.getAccountBalance());
        }
        
        return dto;
    }
    
    public DepositWithdrawDTO withdraw(String accountType, double amount, Membership membership) {
    	DepositWithdrawDTO dto = new DepositWithdrawDTO();
    	dto.setOperationType("Withdrawal");
    	dto.setAccountType(accountType);
        if (accountType.equalsIgnoreCase("Primary")) {
            PrimaryAccount primaryAccount = membership.getPrimaryAccount();
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            primaryAccountDao.save(primaryAccount);

            Date date = new Date();

            PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Withdraw from Primary Account", "WTD", "Finished", amount, primaryAccount.getAccountBalance(), primaryAccount);
            transactionService.savePrimaryWithdrawTransaction(primaryTransaction);
            dto.setAmount(primaryAccount.getAccountBalance());
        } else if (accountType.equalsIgnoreCase("Savings")) {
            SavingsAccount savingsAccount = membership.getSavingsAccount();
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            savingsAccountDao.save(savingsAccount);

            Date date = new Date();
            SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Withdraw from savings Account", "WTD", "Finished", amount, savingsAccount.getAccountBalance(), savingsAccount);
            transactionService.saveSavingsWithdrawTransaction(savingsTransaction);
            dto.setAmount(savingsAccount.getAccountBalance());
        }
        
        return dto;
    }
    
    private int accountGen() {
        return ++nextAccountNumber;
    }
    

}
