package com.tayfint.meethub.dao;

import java.util.List;

import com.tayfint.meethub.model.Meeting;

public interface MeetingDao {
	
	void save(Meeting meeting);
	
	void update(Meeting meeting);
	
	Meeting findByMeetingId(Long meetingId);
	
	Meeting findByMeetingName(String name);
	
	void deleteByMeetingId(Long meetingId);
	
	List<Meeting> findAllMeetings();

}
