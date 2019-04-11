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
		return meetingDao.findById(meetingId);
	}

	@Override
	public void saveMeeting(Meeting meeting) {
		meetingDao.save(meeting);
	}

	@Override
	public Meeting findByMeetingName(String name) {
		return meetingDao.findByName(name);
	}

	@Override
	public List<Meeting> findAllMeetings() {
		return meetingDao.findAll();
	}

	@Override
	public void deleteMeetingById(Long meetingId) {
		meetingDao.deleteById(meetingId);		
	}

}
