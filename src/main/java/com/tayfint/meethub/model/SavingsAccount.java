package com.tayfint.meethub.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="savings_account")
public class SavingsAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "savingsAcct")
	@TableGenerator(name = "savingsAcct", table = "hibernate_id", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "S_ACCT_GEN", allocationSize = 1)
	@Column(name = "ID")
    private Long id;
    private int accountNumber;
    private BigDecimal accountBalance;
    private Date openDate;
	private Date closeDate;
	private Boolean isActive;
	
	public SavingsAccount() {
		this.openDate = new Date();
		this.isActive = true;
	}

    @OneToMany(mappedBy = "savingsAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SavingsTransaction> savingsTransactionList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<SavingsTransaction> getSavingsTransactionList() {
        return savingsTransactionList;
    }

    public void setSavingsTransactionList(List<SavingsTransaction> savingsTransactionList) {
        this.savingsTransactionList = savingsTransactionList;
    }

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}


}
