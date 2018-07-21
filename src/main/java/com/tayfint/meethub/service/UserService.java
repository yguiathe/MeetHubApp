package com.tayfint.meethub.service;

import java.util.List;

import com.tayfint.meethub.model.User;

public interface UserService {
	void saveUser(User user);
	
	User findByUserId(Long userId);
	
	User findByUsername(String username);
	
	void updateUser(User user);
	
	User mergeUser(User user);
	
	void deleteUserByUsername(String username);
	
	List<User> findAllUsers();
	
	boolean isUserUsernameUnique(Long id, String username);
}
