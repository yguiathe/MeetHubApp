package com.tayfint.meethub.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account")
@DiscriminatorValue("SAV")
public class SavingsAccount extends Account {

    private float interestRate;
    private BigDecimal interestBalance;
    private Date lastCycleDate;
    
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	public BigDecimal getInterestBalance() {
		return interestBalance;
	}
	public void setInterestBalance(BigDecimal interestBalance) {
		this.interestBalance = interestBalance;
	}
	public Date getLastCycleDate() {
		return lastCycleDate;
	}
	public void setLastCycleDate(Date lastCycleDate) {
		this.lastCycleDate = lastCycleDate;
	}
	
}
