package com.ss.utopia.tests;

import org.junit.jupiter.api.Test;

import com.ss.utopia.domain.User;
import com.ss.utopia.domain.UserRole;

class UserTest {

	@Test
	void test() {
		User user = new User();
		user.setId(1);
		user.setRole(new UserRole());
		user.setGivenName("Jason");
		user.setFamilyName("Wittmuss");
		user.setUsername("jkwittmuss");
		user.setEmail("jkwittmuss@gmail.com");
		user.setPassword("password");
		user.setPhone("5154233654");
		
		System.out.println(user);
		
		user.getId();
		user.getRole();
		user.getGivenName();
		user.getFamilyName();
		user.getUsername();
		user.getEmail();
		user.getPassword();
		user.getPhone();
		
		// user.adminSelectAdd();
		// user.adminSelectUpdate();
		// user.adminSelectDelete();
		// user.adminSelectRead();
	}

}
