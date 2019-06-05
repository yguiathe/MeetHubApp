package com.tayfint.meethub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tayfint.meethub.model.Meeting;

public interface MeetingDao extends CrudRepository<Meeting,Long> {
	
	Meeting findById(Long meetingId);
	
	Meeting findByName(String name);
	
	void deleteById(Long meetingId);
	
	List<Meeting> findAll();
	
	@Modifying
	@Query("update Meeting mtg set mtg.checkingActId = ?1, mtg.savingActId = ?2 where mtg.id = ?3")
	int setCheckingAndSavingsActIds(Long checkingActId, Long savingActId, Long mtgId);

}
