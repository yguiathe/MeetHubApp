package com.tayfint.meethub.dao;

import com.tayfint.meethub.model.Role;

public interface RoleDao {
	Role findByRole(String role);
}
