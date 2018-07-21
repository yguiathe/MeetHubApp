package com.tayfint.meethub.dao;

import java.util.List;


import com.tayfint.meethub.model.Meeting;
import com.tayfint.meethub.model.User;
import com.tayfint.meethub.model.Membership;

public interface MembershipDao {
	
	void save(Membership userMtg);
	
	void update(Membership userMtg);
	
	List<Membership> retrieveMembershipByUser(User user);
	
	List<User> retrieveUsersByMeeting(Meeting mtg);
	
	void deleteByMembershipId(Long membershipId);

}
