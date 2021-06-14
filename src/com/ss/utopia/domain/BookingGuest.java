package com.ss.utopia.domain;

public class BookingGuest implements Base {
	// class variables
	private Booking booking;
	private String email;
	private String phone;

	// Getter and setter methods
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "BookingGuest [booking=" + booking + ", email=" + email + ", phone=" + phone + "]";
	}
	
	// Below are not used by my current implementation

	@Override
	public void adminSelectAdd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adminSelectUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adminSelectDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adminSelectRead() {
		// TODO Auto-generated method stub
		
	}

}
