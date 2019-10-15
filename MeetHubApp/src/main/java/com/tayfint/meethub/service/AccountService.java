package com.tayfint.meethub.service;

public interface AccountService {

	void add();

	void freeze();

	void delete();

	void deposit();

	void withdraw();

	void transfer();

	void hasSufficientFunds();

	void list();

	void show();

	void getStatement();

	void borrow();
}
