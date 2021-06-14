package com.ss.utopia.tests;

import org.junit.jupiter.api.Test;

import com.ss.utopia.domain.BookingPayment;
import com.ss.utopia.domain.Booking;

class BookingPaymentTest {

	@Test
	void test() {
		BookingPayment bookingPayment = new BookingPayment();
		bookingPayment.setBooking(new Booking());
		bookingPayment.setStripe("1234567890");
		bookingPayment.setRefunded(0);
		
		
		System.out.println(bookingPayment);
		
		bookingPayment.getBooking();
		bookingPayment.getStripe();
		bookingPayment.getRefunded();
		
		bookingPayment.adminSelectAdd();
		bookingPayment.adminSelectUpdate();
		bookingPayment.adminSelectDelete();
		bookingPayment.adminSelectRead();
	}

}
