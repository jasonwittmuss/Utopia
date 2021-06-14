package com.ss.utopia.tests;

import org.junit.jupiter.api.Test;

import com.ss.utopia.domain.Passenger;
import com.ss.utopia.domain.Booking;

class PassengerTest {

	@Test
	void test() {
		Passenger passenger = new Passenger();
		passenger.setId(1);
		passenger.setBooking(new Booking());
		passenger.setGivenName("test");
		passenger.setFamilyName("test");
		passenger.setDob("test");
		passenger.setGender("test");
		passenger.setAddress("test");
		
		System.out.println(passenger);
		
		passenger.getId();
		passenger.getBooking();
		passenger.getGivenName();
		passenger.getFamilyName();
		passenger.getDob();
		passenger.getGender();
		passenger.getAddress();
		
		// passenger.adminSelectAdd();
		// passenger.adminSelectUpdate();
		// passenger.adminSelectDelete();
		passenger.adminSelectRead();
	}

}
