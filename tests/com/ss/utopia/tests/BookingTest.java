package com.ss.utopia.tests;

import org.junit.jupiter.api.Test;

import com.ss.utopia.domain.Booking;

class BookingTest {

	@Test
	void test() {
		Booking booking = new Booking();
		booking.setId(1);
		booking.setIsActive(0);
		booking.setConfirmationCode("CONFIRMATION");
		
		System.out.println(booking);
		
		booking.getId();
		booking.getIsActive();
		booking.getConfirmationCode();
		
		// booking.adminSelectAdd();
		// booking.adminSelectUpdate();
		// booking.adminSelectDelete();
		booking.adminSelectRead();
	}

}
