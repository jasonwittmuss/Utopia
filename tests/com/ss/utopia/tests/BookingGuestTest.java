package com.ss.utopia.tests;

import org.junit.jupiter.api.Test;

import com.ss.utopia.domain.Booking;
import com.ss.utopia.domain.BookingGuest;

class BookingGuestTest {

	@Test
	void test() {
		BookingGuest bookingGuest = new BookingGuest();
		bookingGuest.setBooking(new Booking());
		bookingGuest.setEmail("What@gmail.com");
		bookingGuest.setPhone("1111111111");
		
		System.out.println(bookingGuest);
		
		bookingGuest.getBooking();
		bookingGuest.getEmail();
		bookingGuest.getPhone();
		
		bookingGuest.adminSelectAdd();
		bookingGuest.adminSelectUpdate();
		bookingGuest.adminSelectDelete();
		bookingGuest.adminSelectRead();
	}

}
