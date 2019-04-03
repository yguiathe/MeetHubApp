package com.tayfint.meethub.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TRANSACTION_GEN")
	@TableGenerator(name = "TRANSACTION_GEN", table = "hibernate_id", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "TRANS_GEN", allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	private BigDecimal availableBalance;
	private BigDecimal amount;
	private String status;
	private String type;
	private String description;
	private Date date;
	private Long fromAccountIid;
	private Long toAccountIid;

	public Transaction() {
	}

	public Transaction(Date date, String description, String type, String status, BigDecimal amount,
			BigDecimal availableBalance, Account account, Long fromAccountId, Long toAccountId) {
		this.date = date;
		this.description = description;
		this.type = type;
		this.status = status;
		this.amount = amount;
		this.availableBalance = availableBalance;
		this.account = account;
		this.fromAccountIid = fromAccountId;
		this.toAccountIid = toAccountId;
	}

	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Long getToAccountIid() {
		return toAccountIid;
	}

	public void setToAccountIid(Long toAccountIid) {
		this.toAccountIid = toAccountIid;
	}

	public Long getFromAccountIid() {
		return fromAccountIid;
	}

	public void setFromAccountIid(Long fromAccountIid) {
		this.fromAccountIid = fromAccountIid;
	}
}
