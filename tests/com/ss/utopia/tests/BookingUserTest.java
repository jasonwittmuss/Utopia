package com.ss.utopia.tests;

import org.junit.jupiter.api.Test;

import com.ss.utopia.domain.BookingUser;
import com.ss.utopia.domain.User;
import com.ss.utopia.domain.Booking;

class BookingUserTest {

	@Test
	void test() {
		BookingUser bookingUser = new BookingUser();
		bookingUser.setBooking(new Booking());
		bookingUser.setUser(new User());
		
		System.out.println(bookingUser);
		
		bookingUser.getBooking();
		bookingUser.getUser();
		
		bookingUser.adminSelectAdd();
		bookingUser.adminSelectUpdate();
		bookingUser.adminSelectDelete();
		bookingUser.adminSelectRead();
	}

}
