package com.tayfint.meethub.model.dto;

import java.math.BigDecimal;

public class AccountDto {

	private BigDecimal balance;
	private int accountNumber;
	private String acctType;
	private boolean active = true;
	
	public AccountDto(BigDecimal balance, int accountNumber, String acctType, boolean active) {
		super();
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.acctType = acctType;
		this.active = active;
	}

	public AccountDto() {
		this.balance = null;
		this.accountNumber = 0;
		this.acctType = "CHK";
		this.active = true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result + ((acctType == null) ? 0 : acctType.hashCode());
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountDto other = (AccountDto) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (acctType == null) {
			if (other.acctType != null)
				return false;
		} else if (!acctType.equals(other.acctType))
			return false;
		if (active != other.active)
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		return true;
	}



	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	
}
