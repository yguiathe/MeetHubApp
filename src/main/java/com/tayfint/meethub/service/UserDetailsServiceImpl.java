package com.tayfint.meethub.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tayfint.meethub.model.Role;
import com.tayfint.meethub.model.User;
import com.tayfint.meethub.model.UserDetailsImpl;
import com.tayfint.meethub.service.UserService;

@Service("UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

	static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserService userService;

	@Transactional(readOnly = true)
	public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userService.findByUsername(username);
		logger.info("User: {}", user);
		if (user == null) {
			throw new UsernameNotFoundException("User not found.");
			
		}
		UserDetailsImpl customUserDetails = new UserDetailsImpl();
		customUserDetails.setUser(user);
		customUserDetails.setAuthorities(getGrantedAuthorities(user));
		return customUserDetails;
	}

	private Set<GrantedAuthority> getGrantedAuthorities(User user) {
		Set<GrantedAuthority> authorities =  new HashSet<GrantedAuthority>();
		
		for(Role role: user.getRoles()){
			logger.info("UserRole: {}", role);
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
		}
		return authorities;
	}

}
