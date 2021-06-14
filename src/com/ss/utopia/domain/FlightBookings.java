package com.ss.utopia.domain;

public class FlightBookings implements Base {
	// class variables
	private Flight flight;
	private Booking booking;

	// Getter and setter methods
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	// Overriding the toString function
	public String toString() {
		return "FlightBookings [flight=" + flight + ", booking=" + booking + "]";
	}
	
	// Administrator reading all elements to the database

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
