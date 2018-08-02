package com.tayfint.meethub.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.tayfint.meethub.model.PrimaryTransaction;

public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long> {

    List<PrimaryTransaction> findAll();
}
