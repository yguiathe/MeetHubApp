package com.tayfint.meethub.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tayfint.meethub.model.SavingsAccount;

@Repository
public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber (int accountNumber);
}
