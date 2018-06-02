package com.tayfint.meethub.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayfint.meethub.dao.MeetingDao;
import com.tayfint.meethub.model.Meeting;

@Service("meetingService")
@Transactional
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	MeetingDao meetingDao;
	
	@Override
	public Meeting findByMeetingId(Long meetingId) {
		return meetingDao.findByMeetingId(meetingId);
	}

	@Override
	public void saveMeeting(Meeting meeting) {
		meetingDao.save(meeting);
	}

	@Override
	public Meeting findByMeetingName(String name) {
		return meetingDao.findByMeetingName(name);
	}

	@Override
	public void updateMeeting(Meeting meeting) {
		meetingDao.update(meeting);	
	}

	@Override
	public List<Meeting> findAllMeetings() {
		return meetingDao.findAllMeetings();
	}

	@Override
	public void deleteMeetingById(Long meetingId) {
		meetingDao.deleteByMeetingId(meetingId);		
	}

}
