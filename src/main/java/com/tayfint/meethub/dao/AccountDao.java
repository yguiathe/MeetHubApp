package com.tayfint.meethub.dao;

import java.math.BigDecimal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tayfint.meethub.model.Account;

public interface AccountDao extends CrudRepository<Account,Long> {

    Account findByAccountNumber (int accountNumber);
    
    @Modifying
    @Query("update Account a set a.balance = :balance where a.id = :id")
    void updateBalanceByAcctId(@Param("id") Long id, @Param("balance") BigDecimal balance);
    
    Account findById(Long id);
}
