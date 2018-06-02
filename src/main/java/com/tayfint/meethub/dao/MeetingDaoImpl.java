package com.tayfint.meethub.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tayfint.meethub.model.Meeting;

@Repository
public class MeetingDaoImpl extends AbstractDao<Long, Meeting> implements MeetingDao {
	
	static final Logger logger = LoggerFactory.getLogger(MeetingDaoImpl.class);

	@Override
	public void save(Meeting meeting) {
		persist(meeting);
	}
	
	@Override
	public void update(Meeting meeting) {
		update(meeting);
	}

	@Override
	public Meeting findByMeetingId(Long meetingId) {
		Meeting meeting = getByKey(meetingId);
		if(meeting != null){
			//Hibernate.initialize(user.getUserProfiles());
		}
		return meeting;
	}

	@Override
	public Meeting findByMeetingName(String name) {
		logger.info("Meeting Name : {}", name);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("name", name));
		Meeting meeting = (Meeting) crit.uniqueResult();
		return meeting;
	}

	@Override
	public void deleteByMeetingId(Long meetingId) {
		Meeting meeting = getByKey(meetingId);
		delete(meeting);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Meeting> findAllMeetings() {
		Criteria crit = createEntityCriteria().addOrder(Order.asc("name"));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Meeting> meetings = (List<Meeting>) crit.list();
		return meetings;
	}

}
