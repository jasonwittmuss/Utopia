package com.ss.utopia.domain;

public class BookingPayment implements Base {
	// class variables
	private Booking booking;
	private String stripe;
	private Integer refunded;

	// Getter and setter methods
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public String getStripe() {
		return stripe;
	}

	public void setStripe(String stripe) {
		this.stripe = stripe;
	}

	public Integer getRefunded() {
		return refunded;
	}

	public void setRefunded(Integer refunded) {
		this.refunded = refunded;
	}

	@Override
	// Overriding the toString function
	public String toString() {
		return "BookingPayment [booking=" + booking + ", stripe=" + stripe + ", refunded=" + refunded + "]";
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
