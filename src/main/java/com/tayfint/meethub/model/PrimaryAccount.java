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
@Table(name = "primary_account")
public class PrimaryAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "primaryAcct")
	@TableGenerator(name = "primaryAcct", table = "hibernate_id", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "P_ACCT_GEN", allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	private BigDecimal accountBalance;
	private int accountNumber;
	private Date openDate;
	private Date closeDate;
	private boolean isActive;
	
	public PrimaryAccount() {
		this.openDate = new Date();
		this.isActive = true;
	}

	@OneToMany(mappedBy = "primaryAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PrimaryTransaction> primaryTransactionList;

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

    public List<PrimaryTransaction> getPrimaryTransactionList() {
        return primaryTransactionList;
    }

    public void setPrimaryTransactionList(List<PrimaryTransaction> primaryTransactionList) {
        this.primaryTransactionList = primaryTransactionList;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
