package com.tayfint.meethub.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayfint.meethub.dao.MembershipDao;
import com.tayfint.meethub.model.Meeting;
import com.tayfint.meethub.model.Membership;
import com.tayfint.meethub.model.User;

@Service("membershipService")
@Transactional
public class MembershipServiceImpl implements MembershipService {
	
	@Autowired
	MembershipDao membershipDao;

	public void save(Membership membership) {
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
	public void saveMembership(Meeting meeting, User user) {
		Membership membership = new Membership();
		membership.setMeeting(meeting);
		membership.setUser(user);
		save(membership);
	}

	@Override
	public Membership findMembershipById(Long membershipId) {
		return membershipDao.findOne(membershipId);
	}

}
