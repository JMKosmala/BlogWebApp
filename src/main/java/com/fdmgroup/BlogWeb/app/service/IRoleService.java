package com.fdmgroup.BlogWeb.app.service;

import com.fdmgroup.BlogWeb.app.model.Role;

public interface IRoleService {

		Role findByRoleName (String roleName);
}
