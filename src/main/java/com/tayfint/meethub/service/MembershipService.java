package com.tayfint.meethub.service;

import java.util.List;

import com.tayfint.meethub.model.Meeting;
import com.tayfint.meethub.model.Membership;
import com.tayfint.meethub.model.User;

public interface MembershipService {

	void saveMembership(Meeting meeting, User user);
	
	void deleteMembershipById(Long membershipId);
	
	List<Membership> findMembershipByUser(User user);
	
	Membership findMembershipByUserAndMeeting(User user, Meeting meeting);
}
