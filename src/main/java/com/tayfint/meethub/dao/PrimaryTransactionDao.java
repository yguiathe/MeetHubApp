package com.tayfint.meethub.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tayfint.meethub.model.PrimaryTransaction;

@Repository
public interface PrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long> {

    List<PrimaryTransaction> findAll();
}
