package com.tayfint.meethub.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tayfint.meethub.dao.RoleDao;
import com.tayfint.meethub.dao.UserDao;
import com.tayfint.meethub.model.Role;
import com.tayfint.meethub.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void saveUser(User user) {
		user.setIsActive(true);
		user.setRoles(new HashSet<Role>(Arrays.asList(roleDao.findByRole("USER"))));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.save(user);
	}

	@Override
	public User findByUserId(Long userId) {
		return userDao.findByUserId(userId);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Override
	public void deleteUserByUsername(String username) {
		userDao.deleteByUsername(username);
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	@Override
	public boolean isUserUsernameUnique(Long id, String username) {
		User user = findByUsername(username);
		return (user == null || (user.getUserId().compareTo(id) == 0));
	}

}
