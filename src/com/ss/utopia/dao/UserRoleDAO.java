package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.domain.UserRole;

public class UserRoleDAO extends BaseDAO<UserRole> {

	// Constructor with connection
	public UserRoleDAO(Connection conn) {
		super(conn);
	}

	// Add sql statement given a user role
	public void addUserRole(UserRole userRole) throws ClassNotFoundException, SQLException {
		save("insert into user_role (?, ?)", new Object[] { userRole.getId(), userRole.getName() });
	}

	// Update sql statement given a user role
	public void updateUserRole(UserRole userRole) throws ClassNotFoundException, SQLException {
		save("update user_role set name = ? where id = ?", new Object[] { userRole.getName(), userRole.getId() });
	}

	// Delete Sql statement given a user role
	public void deleteUserRole(UserRole userRole) throws ClassNotFoundException, SQLException {
		save("delete from user_role where id = ?", new Object[] { userRole.getId() });
	}

	// Read Sql statement given a user role
	public List<UserRole> readAllUserRoles() throws ClassNotFoundException, SQLException {
		return read("select * from user_role", null);
	}

	// Get a user role given id Sql statement given a user role
	public UserRole getUserRole(Integer id) throws ClassNotFoundException, SQLException {
		List<UserRole> userRoles = read("select * from user_role where id = ?", new Object[] { id });

		return userRoles.get(0);
	}

	@Override
	// Convert query response to list of objects
	public List<UserRole> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<UserRole> userRoles = new ArrayList<>();
		while (results.next()) {
			UserRole userRole = new UserRole();
			userRole.setId(results.getInt("id"));
			userRole.setName(results.getString("name"));
			userRoles.add(userRole);
		}
		return userRoles;
	}

}
