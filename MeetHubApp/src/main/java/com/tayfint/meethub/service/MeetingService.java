package com.tayfint.meethub.service;

import java.util.List;
import java.util.Optional;

import com.tayfint.meethub.model.Meeting;

public interface MeetingService {
	
	Meeting saveMeeting(Meeting meeting);
	
	Optional<Meeting> findByMeetingId(Long meetingId);
	
	Meeting findByMeetingName(String name);
	
	void deleteMeetingById(Long meetingId);
	
	List<Meeting> findAllMeetings();

}
