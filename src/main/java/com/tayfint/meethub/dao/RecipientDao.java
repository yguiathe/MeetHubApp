package com.tayfint.meethub.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tayfint.meethub.model.Recipient;

@Repository
public interface RecipientDao extends CrudRepository<Recipient, Long> {
    List<Recipient> findAll();

    Recipient findByName(String recipientName);

    void deleteByName(String recipientName);
}
