package com.fdmgroup.BlogWeb.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.BlogWeb.app.model.Role;
import com.fdmgroup.BlogWeb.app.repositories.RoleRepository;

@Service
public class RoleService implements IRoleService {

	@Autowired
	RoleRepository roleRepo;
	
	@Override
	public Role findByRoleName(String roleName) {
		
		Optional<Role>optRole=roleRepo.findByRoleName(roleName);
		return optRole.orElse(new Role ("default role"));
	}

}
