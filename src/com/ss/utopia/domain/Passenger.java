package com.ss.utopia.domain;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.service.AdminService;

public class Passenger implements Base {
	// class variables
	private Integer id;
	private Booking booking;
	private String givenName;
	private String familyName;
	private String dob;
	private String gender;
	private String address;

	// Getter and setter methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	// Overriding the toString function
	public String toString() {
		return "Passenger [id=" + id + ", booking=" + booking + ", givenName=" + givenName + ", familyName="
				+ familyName + ", dob=" + dob + ", gender=" + gender + ", address=" + address + "]";
	}

	@Override
	// Administrator adding an element to the database
	public void adminSelectAdd() {
		Passenger passenger = new Passenger();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Passenger ID: ");
		passenger.setId(input.nextInt());
		
		System.out.print("First Name: ");
		passenger.setGivenName(input.nextLine());
		
		System.out.print("Last Name: ");
		passenger.setFamilyName(input.nextLine());
		
		System.out.print("Booking ID: ");
		passenger.setBooking(new Booking());
		passenger.getBooking().setId(Integer.parseInt(input.nextLine()));
		
		System.out.print("DOB: ");
		passenger.setDob(input.nextLine());
		
		System.out.print("Gender: ");
		passenger.setGender(input.nextLine());
		
		System.out.print("Address: ");
		passenger.setAddress(input.nextLine());
		
		AdminService admin = new AdminService();
		try {
			admin.addPassenger(passenger);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		input.close();
		
	}

	@Override
	// Administrator updating an element to the database
	public void adminSelectUpdate() {
		Passenger passenger = new Passenger();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Passenger ID: ");
		passenger.setId(input.nextInt());
		
		System.out.print("First Name: ");
		passenger.setGivenName(input.nextLine());
		
		System.out.print("Last Name: ");
		passenger.setFamilyName(input.nextLine());
		
		System.out.print("Booking ID: ");
		passenger.setBooking(new Booking());
		passenger.getBooking().setId(Integer.parseInt(input.nextLine()));
		
		System.out.print("DOB: ");
		passenger.setDob(input.nextLine());
		
		System.out.print("Gender: ");
		passenger.setGender(input.nextLine());
		
		System.out.print("Address: ");
		passenger.setAddress(input.nextLine());
		
		AdminService admin = new AdminService();
		try {
			admin.updatePassenger(passenger);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		input.close();
	}

	@Override
	// Administrator deleting an element to the database
	public void adminSelectDelete() {
		Passenger passenger = new Passenger();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Passenger ID: ");
		passenger.setId(input.nextInt());
		
		AdminService admin = new AdminService();
		try {
			admin.deletePassenger(passenger);
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
			List<Passenger> passengers = admin.readPassenger();
			for (Passenger passenger : passengers) {
				System.out.println(passenger);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
