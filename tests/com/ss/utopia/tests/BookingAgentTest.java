package com.ss.utopia.tests;

import org.junit.jupiter.api.Test;

import com.ss.utopia.domain.Booking;
import com.ss.utopia.domain.BookingAgent;
import com.ss.utopia.domain.User;

class BookingAgentTest {

	@Test
	void test() {
		BookingAgent airplane = new BookingAgent();
		airplane.setBooking(new Booking());
		airplane.setUser(new User());
		
		System.out.println(airplane);
		
		airplane.getBooking();
		airplane.getUser();
		
		airplane.adminSelectAdd();
		airplane.adminSelectUpdate();
		airplane.adminSelectDelete();
		airplane.adminSelectRead();
	}

}
