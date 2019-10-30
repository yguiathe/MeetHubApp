package com.tayfint.meethub.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.tayfint.meethub.model.Meeting;

public interface MeetingDao extends CrudRepository<Meeting,Long> {
	
	Optional<Meeting> findById(Long meetingId);
	
	Meeting findByName(String name);
	
	void deleteById(Long meetingId);
	
	List<Meeting> findAll();
}
