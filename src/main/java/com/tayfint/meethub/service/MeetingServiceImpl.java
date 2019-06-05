package com.tayfint.meethub.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayfint.meethub.dao.MeetingDao;
import com.tayfint.meethub.dao.RoleDao;
import com.tayfint.meethub.model.Meeting;
import com.tayfint.meethub.model.User;
import com.tayfint.meethub.model.security.UserRole;

@Service("meetingService")
@Transactional
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	MeetingDao meetingDao;

	@Autowired
	RoleDao roleDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MembershipService membershipService;
	
	@Override
	public Meeting findByMeetingId(Long meetingId) {
		return meetingDao.findById(meetingId);
	}

	@Override
	public Meeting saveMeeting(Meeting meeting) {
		// Creates Meeting user
		User user = new User();
		Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));
        user.setUsername(meeting.getName().replace(" ", ""));
        user.setLastName(meeting.getName().replace(" ", "_"));
        user.setIsGroup(true);
        meeting = meetingDao.save(meeting);
        membershipService.saveMembership(meeting, userService.createUser(user, userRoles), "0");
        return meeting;
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
