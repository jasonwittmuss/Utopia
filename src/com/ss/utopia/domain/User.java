package com.ss.utopia.domain;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.service.AdminService;

public class User implements Base {
	// class variables
	private Integer id;
	private UserRole role;
	private String givenName;
	private String familyName;
	private String username;
	private String email;
	private String password;
	private String phone;

	// Getter and setter methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	// Overriding the toString function
	public String toString() {
		return "User [id=" + id + ", role=" + role + ", givenName=" + givenName + ", familyName=" + familyName
				+ ", username=" + username + ", email=" + email + ", password=" + password + ", phone=" + phone + "]";
	}

	@Override
	// Administrator adding an element to the database
	public void adminSelectAdd() {
		User user = new User();
		Scanner input = new Scanner(System.in);
		
		System.out.print("First Name: ");
		user.setGivenName(input.nextLine());
		
		System.out.print("Last Name: ");
		user.setFamilyName(input.nextLine());
		
		System.out.print("Role (1-Administrator, 2-Agent, 3-User): ");
		user.setRole(new UserRole());
		user.getRole().setId(Integer.parseInt(input.nextLine()));
		
		System.out.print("Username: ");
		user.setUsername(input.nextLine());
		
		System.out.print("Password: ");
		user.setPassword(input.nextLine());
		
		System.out.print("Email: ");
		user.setEmail(input.nextLine());
		
		System.out.print("Phone: ");
		user.setPhone(input.nextLine());
		
		AdminService admin = new AdminService();
		try {
			admin.addUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		
		input.close();
	}

	@Override
	// Administrator updating an element to the database
	public void adminSelectUpdate() {
		User user = new User();
		Scanner input = new Scanner(System.in);
		
		System.out.print("User ID: ");
		user.setId(input.nextInt());
		
		System.out.print("First Name: ");
		user.setGivenName(input.nextLine());
		
		System.out.print("Last Name: ");
		user.setFamilyName(input.nextLine());
		
		System.out.print("Role (1-Administrator, 2-Agent, 3-User): ");
		user.setRole(new UserRole());
		user.getRole().setId(Integer.parseInt(input.nextLine()));
		
		System.out.print("Username: ");
		user.setUsername(input.nextLine());
		
		System.out.print("Password: ");
		user.setPassword(input.nextLine());
		
		System.out.print("Email: ");
		user.setEmail(input.nextLine());
		
		System.out.print("Phone: ");
		user.setPhone(input.nextLine());
		
		AdminService admin = new AdminService();
		try {
			admin.updateUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		input.close();
	}

	@Override
	// Administrator deleting an element to the database
	public void adminSelectDelete() {
		User user = new User();
		Scanner input = new Scanner(System.in);
		
		System.out.print("User ID: ");
		user.setId(input.nextInt());
		
		AdminService admin = new AdminService();
		try {
			admin.updateUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		input.close();
		
	}

	@Override
	// Administrator reading all elements to the database
	public void adminSelectRead() {
		AdminService admin = new AdminService();
		try {
			List<User> users = admin.readUsers();
			for (User user : users) {
				System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
