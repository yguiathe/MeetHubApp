package com.tayfint.meethub.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayfint.meethub.dao.AccountDao;
import com.tayfint.meethub.model.Account;
import com.tayfint.meethub.model.CheckingAccount;
import com.tayfint.meethub.model.InvestmentAccount;
import com.tayfint.meethub.model.LoanAccount;
import com.tayfint.meethub.model.SavingsAccount;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
	
	private static int nextAccountNumber = 1000000;

    @Autowired
    private AccountDao accountDao;
    
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
	public void freeze() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account deposit(Account toAccount, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account withdraw(Account fromAccount, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account transfer(String transferFrom, String transferTo, BigDecimal amount, Account fromAccount,
			Account toAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hasSufficientFunds(Account acct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Account> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getStatement(Account acct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrow() {
		// TODO Auto-generated method stub
		
	}
	
	private String accountGen() {
        return String.valueOf(++nextAccountNumber);
    }

	@Override
	public Optional<Account> findById(Long id) {
		return accountDao.findById(id);
	}
}
