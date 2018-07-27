package com.tayfint.meethub.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tayfint.meethub.model.Meeting;
import com.tayfint.meethub.model.User;
import com.tayfint.meethub.model.Membership;

@Repository
public interface MembershipDao extends CrudRepository<Membership,Long> {
	
	List<Membership> findMembershipByUser(User user);
	
	Membership findMembershipByUserAndMeeting(User user, Meeting meeting);
	
	void deleteMembershipById(Long membershipId);

}
