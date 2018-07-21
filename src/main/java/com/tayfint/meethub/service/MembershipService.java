package com.tayfint.meethub.service;

import com.tayfint.meethub.model.Membership;

public interface MembershipService {

	void saveMembership(Membership membership);
	
	void deleteMembershipById(Long membershipId);
}
