package com.fdmgroup.BlogWeb.app.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.fdmgroup.BlogWeb.app.model.User;

public interface IDefaultUserDetailService extends  UserDetailsService {
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	public User findByUsername (String username);
	public void saveUser (User user);
}
