package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.domain.User;

public class UserDAO extends BaseDAO<User> {

	// Constructor with connection
	public UserDAO(Connection conn) {
		super(conn);
	}

	// Add sql statement given a user
	public void addUser(User user) throws ClassNotFoundException, SQLException {
		save("insert into user ( role_id , given_name , family_name , username , email , password , phone ) values (?, ?, ?, ?, ?, ?, ?)",
				new Object[] { user.getRole().getId(), user.getGivenName(), user.getFamilyName(),
						user.getUsername(), user.getEmail(), user.getPassword(), user.getPhone() });
	}

	// Update sql statement given a user
	public void updateUser(User user) throws ClassNotFoundException, SQLException {
		save("update user set role_id = ? and given_name = ? and family_name = ? and username = ? and email = ? and password = ? and phone = ? where id = ?",
				new Object[] { user.getRole().getId(), user.getGivenName(), user.getFamilyName(), user.getUsername(),
						user.getEmail(), user.getPassword(), user.getPhone(), user.getId() });
	}

	// Delete Sql statement given a user
	public void deleteUser(User user) throws ClassNotFoundException, SQLException {
		save("delete from user where id = ?", new Object[] { user.getId() });
	}

	// Read Sql statement given a user
	public List<User> readAllUsers() throws ClassNotFoundException, SQLException {
		return read("select * from user", null);
	}

	// Get a user role given id Sql statement given a user
	public User getUser(Integer id) throws ClassNotFoundException, SQLException {
		List<User> users = read("select * from user where id = ?", new Object[] { id });

		return users.get(0);
	}

	@Override
	// Convert query response to list of objects
	public List<User> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<User> users = new ArrayList<>();
		UserRoleDAO udao = new UserRoleDAO(conn);
		while (results.next()) {
			User user = new User();
			user.setId(results.getInt("id"));
			user.setRole(udao.getUserRole(results.getInt("role_id")));
			user.setGivenName(results.getString("given_name"));
			user.setFamilyName(results.getString("family_name"));
			user.setUsername(results.getString("username"));
			user.setEmail(results.getString("email"));
			user.setPassword(results.getString("password"));
			user.setPhone(results.getString("phone"));
			users.add(user);
		}
		return users;
	}

}