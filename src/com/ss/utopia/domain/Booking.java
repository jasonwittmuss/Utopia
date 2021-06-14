package com.ss.utopia.domain;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.service.AdminService;

public class Booking implements Base {
	// class variables
	private Integer id;
	private Integer isActive;
	private String confirmationCode;

	// Getter and setter methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getConfirmationCode() {
		return confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	@Override
	// Overriding the toString function
	public String toString() {
		return "Booking [id=" + id + ", isActive=" + isActive + ", confirmationCode=" + confirmationCode + "]";
	}

	@Override
	// Administrator adding an element to the database
	public void adminSelectAdd() {
		Booking booking = new Booking();
		Scanner input = new Scanner(System.in);

		System.out.print("User ID: ");
		booking.setId(Integer.parseInt(input.nextLine()));

		System.out.print("Active? (0-Yes, 1-No): ");
		booking.setIsActive(Integer.parseInt(input.nextLine()));

		System.out.print("Confirmation Code: ");
		booking.setConfirmationCode(input.nextLine());

		AdminService admin = new AdminService();
		try {
			admin.addBooking(booking);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		input.close();
	}

	@Override
	// Administrator updating an element to the database
	public void adminSelectUpdate() {
		Booking booking = new Booking();
		Scanner input = new Scanner(System.in);

		System.out.print("User ID: ");
		booking.setId(input.nextInt());

		System.out.print("Active? (0-Yes, 1-No): ");
		booking.setIsActive(Integer.parseInt(input.nextLine()));

		System.out.print("Confirmation Code: ");
		booking.setConfirmationCode(input.nextLine());

		AdminService admin = new AdminService();
		try {
			admin.updateBooking(booking);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		input.close();
	}

	@Override
	// Administrator deleting an element to the database
	public void adminSelectDelete() {
		Booking booking = new Booking();
		Scanner input = new Scanner(System.in);

		System.out.print("User ID: ");
		booking.setId(input.nextInt());

		AdminService admin = new AdminService();
		try {
			admin.deleteBooking(booking);
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
			List<Booking> bookings = admin.readBookings();
			for (Booking booking : bookings) {
				System.out.println(booking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
