package com.fdmgroup.BlogWeb.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fdmgroup.BlogWeb.app.model.User;
import com.fdmgroup.BlogWeb.app.repositories.UserRepository;
import com.fdmgroup.BlogWeb.app.security.UserPrincipal;

@Service
public class DefaultUserDetailService implements IDefaultUserDetailService{

	
	private UserRepository userRepo;
	
	@Autowired 
	private DefaultUserDetailService (UserRepository userRepo) {
		this.userRepo=userRepo;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =findByUsername(username);
		return new UserPrincipal(user);
	}
	@Override
	public User findByUsername (String username) {
		Optional<User> optUser =userRepo.findByUsername(username);
		User user = optUser.orElse(new User("default username"));
		return user;
	}
	@Override
	public void saveUser (User user) {
		userRepo.save(user);
	}
}
