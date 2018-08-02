package com.tayfint.meethub.dao;

import org.springframework.data.repository.CrudRepository;
import com.tayfint.meethub.model.SavingsAccount;

public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber (int accountNumber);
}
