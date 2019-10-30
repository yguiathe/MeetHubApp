package com.tayfint.meethub.service;

import java.util.List;
import java.util.Optional;

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

	/*
	 * @Autowired private UserService userService;
	 */
	
	@Autowired
    private AccountService accountService;

	@Override
	public Meeting saveMeeting(Meeting meeting) {
		meeting.addAccount(accountService.createPrimaryAccount());
		meeting.addAccount(accountService.createSavingsAccount());
		return meetingDao.save(meeting);
	}

	@Override
	public Optional<Meeting> findByMeetingId(Long meetingId) {
		return meetingDao.findById(meetingId);
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
