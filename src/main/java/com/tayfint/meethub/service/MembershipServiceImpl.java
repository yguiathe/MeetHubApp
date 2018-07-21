package com.tayfint.meethub.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayfint.meethub.dao.MembershipDao;
import com.tayfint.meethub.model.Membership;

@Service("membershipService")
@Transactional
public class MembershipServiceImpl implements MembershipService {
	
	@Autowired
	MembershipDao membershipDao;

	@Override
	public void saveMembership(Membership membership) {
		membershipDao.save(membership);
	}

	@Override
	public void deleteMembershipById(Long membershipId) {
		membershipDao.deleteByMembershipId(membershipId);
	}

}
