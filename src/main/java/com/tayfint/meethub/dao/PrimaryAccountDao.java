package com.tayfint.meethub.dao;

import org.springframework.data.repository.CrudRepository;
import com.tayfint.meethub.model.PrimaryAccount;

public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount,Long> {

    PrimaryAccount findByAccountNumber (int accountNumber);
}
