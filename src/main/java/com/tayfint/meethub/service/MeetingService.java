package com.tayfint.meethub.service;

import java.util.List;

import com.tayfint.meethub.model.Meeting;

public interface MeetingService {
	
	void saveMeeting(Meeting meeting);
	
	Meeting findByMeetingId(Long meetingId);
	
	Meeting findByMeetingName(String name);
	
	void updateMeeting(Meeting meeting);
	
	void deleteMeetingById(Long meetingId);
	
	List<Meeting> findAllMeetings();

}
