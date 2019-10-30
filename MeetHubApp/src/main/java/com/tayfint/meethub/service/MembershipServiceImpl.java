package com.tayfint.meethub.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tayfint.meethub.dao.MembershipDao;
import com.tayfint.meethub.model.Meeting;
import com.tayfint.meethub.model.Membership;
import com.tayfint.meethub.model.User;

@Service("membershipService")
@Transactional
public class MembershipServiceImpl implements MembershipService {
	
	@Autowired
	MembershipDao membershipDao;
	
	@Autowired
    private AccountService accountService;
	
	@Autowired
	private MeetingService meetingService;
	
	static final Logger logger = LoggerFactory.getLogger(MembershipServiceImpl.class);
	
	public void save(Membership membership) {
		membership.addAccount(accountService.createPrimaryAccount());
		membership.addAccount(accountService.createSavingsAccount());
		membershipDao.save(membership);
	}

	@Override
	public void deleteMembershipById(Long membershipId) {
		membershipDao.deleteById(membershipId);
	}

	@Override
	public List<Membership> findMembershipByUser(User user) {
		return membershipDao.findByUser(user);
	}

	@Override
	public Membership findMembershipByUserAndMeeting(User user, Meeting meeting) {
		return membershipDao.findByUserAndMeeting(user, meeting);
	}

	@Override
	public void saveMembership(Meeting meeting, User user, String typeCd) {
		Membership membership = new Membership();
		membership.setTypeCd(typeCd);
		user.setTeamsCnt(user.getTeamsCnt() + 1);
		meeting.setMembersCnt(meeting.getMembersCnt() + 1);
		membership.setMeeting(meetingService.saveMeeting(meeting));
		membership.setUser(user);
		save(membership);
	}

	@Override
	public Optional<Membership> findMembershipById(Long membershipId) {
		return membershipDao.findById(membershipId);
	}

	@Override
	public Membership fetchMembershipWithAccounts(Long membershipId) {
		return membershipDao.findByIdAndFetchAccountsEagerly(membershipId);
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void terminate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suspend() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAge() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAccounts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

}