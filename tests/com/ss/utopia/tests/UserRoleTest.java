package com.ss.utopia.tests;

import org.junit.jupiter.api.Test;

import com.ss.utopia.domain.UserRole;

class UserRoleTest {

	@Test
	void test() {
		UserRole userRole = new UserRole();
		userRole.setId(1);
		userRole.setName("");
		
		System.out.println(userRole);
		
		userRole.getId();
		userRole.getName();
		
		userRole.adminSelectAdd();
		userRole.adminSelectUpdate();
		userRole.adminSelectDelete();
		userRole.adminSelectRead();
	}

}
