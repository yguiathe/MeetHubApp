package com.tayfint.meethub.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tayfint.meethub.model.User;

@Repository
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {
	
	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Override
	public void save(User user) {
		persist(user);
	}
	
	@Override
	public User mergeUser(User user){
		return (User) merge(user);
	}
	
	@Override
	public void update(User user) {
		update(user);
	}

	@Override
	public User findByUserId(Long userId) {
		User user = getByKey(userId);
		if(user != null){
			//Hibernate.initialize(user.getUserProfiles());
		}
		return user;
	}

	@Override
	public User findByUsername(String username) {
		logger.info("Username : {}", username);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("username", username));
		User user = (User) crit.uniqueResult();
		return user;
	}

	@Override
	public void deleteByUsername(String username) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("username", username));
		User user = (User) crit.uniqueResult();
		delete(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		Criteria crit = createEntityCriteria().addOrder(Order.asc("lastName"));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<User> users = (List<User>) crit.list();
		return users;
	}

}
