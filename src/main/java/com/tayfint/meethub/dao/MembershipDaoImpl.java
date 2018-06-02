package com.tayfint.meethub.dao;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tayfint.meethub.model.Meeting;
import com.tayfint.meethub.model.User;
import com.tayfint.meethub.model.Membership;

@Repository
public class MembershipDaoImpl extends AbstractDao<Long, Membership> implements MembershipDao {

	static final Logger logger = LoggerFactory.getLogger(MembershipDaoImpl.class);
	
	@Override
	public void save(Membership userMtg) {
		persist(userMtg);
	}

	@Override
	public void update(Membership userMtg) {
		update(userMtg);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Membership> retrieveMembershipByUser(User user) {
		Query query = createEntityQuery("Select m FROM Membership m WHERE m.appUser = :user");
		query.setParameter("user", user);
		return (List<Membership>) query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> retrieveUsersByMeeting(Meeting mtg) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("appMeeting", mtg));
		return (List<User>) crit.list();
	}

	@Override
	public void deleteByMeetingAndUser(Meeting mtg, User user) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("appMeeting", mtg));
		crit.add(Restrictions.eq("appUser", user));
		delete((Membership) crit.uniqueResult());
	}

}
