package com.tayfint.meethub.service;

import java.math.BigDecimal;
import java.util.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayfint.meethub.dao.AccountDao;
import com.tayfint.meethub.dao.TransactionDao;
import com.tayfint.meethub.model.Account;
import com.tayfint.meethub.model.CheckingAccount;
import com.tayfint.meethub.model.InvestmentAccount;
import com.tayfint.meethub.model.LoanAccount;
import com.tayfint.meethub.model.SavingsAccount;
import com.tayfint.meethub.model.Transaction;
import com.tayfint.meethub.model.TransactionStatus;
import com.tayfint.meethub.model.TransactionType;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
	
	private static int nextAccountNumber = 1000000;

    @Autowired
    private AccountDao accountDao;
    
    @Autowired
	private TransactionDao transactionDao;
    
    static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    public Account createPrimaryAccount() {
        Account primaryAccount = new CheckingAccount();
        primaryAccount.setBalance(new BigDecimal(0.0));
        primaryAccount.setAccountNumber(accountGen());

        return accountDao.save(primaryAccount);
    }

    public Account createSavingsAccount() {
        Account savingsAccount = new SavingsAccount();
        savingsAccount.setBalance(new BigDecimal(0.0));
        savingsAccount.setAccountNumber(accountGen());

        return accountDao.save(savingsAccount);
    }

	@Override
	public Account createLoanAccount() {
		Account loanAccount = new LoanAccount();
		loanAccount.setBalance(new BigDecimal(0.0));
		loanAccount.setAccountNumber(accountGen());

        return accountDao.save(loanAccount);
	}

	@Override
	public Account createInvestmentAccount() {
		Account investmentAccount = new InvestmentAccount();
		investmentAccount.setBalance(new BigDecimal(0.0));
		investmentAccount.setAccountNumber(accountGen());

        return accountDao.save(investmentAccount);
	}
	
	@Override
	public Account deposit(Account toAccount, BigDecimal amount) {
		BigDecimal balance = toAccount.getBalance().add(amount);
		Long toAcctId = toAccount.getId();
		transactionDao.save(new Transaction(new Date(), "meethub.deposit." + getTrsDescAppender(toAccount),
				TransactionType.DEPOSIT.toString(), TransactionStatus.PROCESSED.toString(), amount,
				balance, toAccount, null, toAcctId));
		toAccount.setBalance(balance);
		accountDao.updateBalanceByAcctId(toAcctId, balance);
		return toAccount;
	}

	@Override
	public Account withdraw(Account fromAccount, BigDecimal amount) {
		BigDecimal balance = fromAccount.getBalance().subtract(amount);
		Long fromAcctId = fromAccount.getId();
		transactionDao.save(new Transaction(new Date(), "meethub.withdraw." + getTrsDescAppender(fromAccount),
				TransactionType.WITHDRAW.toString(), TransactionStatus.PROCESSED.toString(), amount,
				balance, fromAccount, fromAccount.getId(), null));
		fromAccount.setBalance(balance);
		accountDao.updateBalanceByAcctId(fromAcctId, balance);
		return fromAccount;
	}

	@Override
	public Account transfer(String transferFrom, String transferTo, BigDecimal amount, Account fromAccount,
			Account toAccount) {
		return fromAccount;
	}

	public String getTrsDescAppender(Account account) {
		String description = "";
		if (account instanceof CheckingAccount) {
			description += "checking";
		} else if (account instanceof SavingsAccount) {
			description += "saving";
		} else if (account instanceof LoanAccount) {
			description += "loan";
		} else if (account instanceof InvestmentAccount) {
			description += "investment";
		} else {
			description += "others";
		}
		return description;
	}
    
    private int accountGen() {
        return ++nextAccountNumber;
    }

	@Override
	public Account findById(Long id) {
		return accountDao.findById(id);
	}
}
