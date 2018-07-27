package com.tayfint.meethub.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tayfint.meethub.model.PrimaryAccount;

@Repository
public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount,Long> {

    PrimaryAccount findByAccountNumber (int accountNumber);
}
