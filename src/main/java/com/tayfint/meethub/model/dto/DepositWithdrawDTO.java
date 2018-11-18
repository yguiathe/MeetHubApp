package com.tayfint.meethub.model.dto;

import java.math.BigDecimal;

public class DepositWithdrawDTO {

	private String accountType;
	
	private BigDecimal amount;
	
	private String operationType;
	
	public DepositWithdrawDTO(){
		this.accountType = "";
		this.operationType = "";
		this.amount = BigDecimal.ZERO;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal bigDecimal) {
		this.amount = bigDecimal;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
}
