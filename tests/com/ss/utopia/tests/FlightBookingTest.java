package com.ss.utopia.tests;

import org.junit.jupiter.api.Test;

import com.ss.utopia.domain.FlightBookings;
import com.ss.utopia.domain.Booking;
import com.ss.utopia.domain.Flight;

class FlightBookingTest {

	@Test
	void test() {
		FlightBookings flightBookings = new FlightBookings();
		flightBookings.setFlight(new Flight());
		flightBookings.setBooking(new Booking());
		
		System.out.println(flightBookings);
		
		flightBookings.getFlight();
		flightBookings.getBooking();
		
		flightBookings.adminSelectAdd();
		flightBookings.adminSelectUpdate();
		flightBookings.adminSelectDelete();
		flightBookings.adminSelectRead();
	}

}
