package com.tayfint.meethub.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tayfint.meethub.model.Account;

public interface AccountDao extends CrudRepository<Account,Long> {

    Account findByAccountNumber (int accountNumber);
    
    Optional<Account> findById(Long id);
}
