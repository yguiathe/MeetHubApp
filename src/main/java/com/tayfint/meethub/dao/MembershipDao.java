package com.tayfint.meethub.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.tayfint.meethub.model.Meeting;
import com.tayfint.meethub.model.User;
import com.tayfint.meethub.model.Membership;

public interface MembershipDao extends CrudRepository<Membership,Long> {
	
	List<Membership> findByUser(User user);
	
	Membership findByUserAndMeeting(User user, Meeting meeting);
	
	void deleteById(Long membershipId);

}
