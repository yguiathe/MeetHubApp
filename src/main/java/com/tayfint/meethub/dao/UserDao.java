package com.tayfint.meethub.dao;

import java.util.List;

import com.tayfint.meethub.model.User;

public interface UserDao {
	
	void save(User user);
	
	void update(User user);
	
	User findByUserId(Long userId);
	
	User findByUsername(String username);
	
	void deleteByUsername(String username);
	
	List<User> findAllUsers();

}
