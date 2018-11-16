package com.tayfint.meethub.model.form;

public class DepositWithdrawForm {

	private String accountType;
	
	private String amount;
	
	private String operationType;
	
	public DepositWithdrawForm(){
		this.accountType = "";
		this.operationType = "";
		this.amount = "0";
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
}
