package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.domain.BookingPayment;

public class BookingPaymentDAO extends BaseDAO<BookingPayment> {

	// Constructor with connection
	public BookingPaymentDAO(Connection conn) {
		super(conn);
	}

	// Add sql statement given a booking payment
	public void addBookingPayment(BookingPayment bookingPayment) throws ClassNotFoundException, SQLException {
		save("insert into booking_payment (?, ?, ?)", new Object[] { bookingPayment.getBooking().getId(),
				bookingPayment.getStripe(), bookingPayment.getRefunded() });
	}

	// Update sql statement given a booking payment
	public void updateBookingPayment(BookingPayment bookingPayment) throws ClassNotFoundException, SQLException {
		save("update booking_payment set stripe_id = ? and refunded = ? where booking_id = ?", new Object[] {
				bookingPayment.getStripe(), bookingPayment.getRefunded(), bookingPayment.getBooking().getId() });
	}

	// Delete Sql statement given a booking payment
	public void deleteBookingPayment(BookingPayment bookingPayment) throws ClassNotFoundException, SQLException {
		save("delete from booking_payment where booking_id = ?", new Object[] { bookingPayment.getBooking().getId() });
	}

	// Read Sql statement given a booking payment
	public List<BookingPayment> readAllBookingPayments() throws ClassNotFoundException, SQLException {
		return read("select * from booking_payment", null);
	}

	// Get a booking payment given id Sql statement given a 
	public BookingPayment getRoute(Integer id) throws ClassNotFoundException, SQLException {
		List<BookingPayment> bookingPayments = read("select * from booking_payment where booking_id = ?",
				new Object[] { id });

		return bookingPayments.get(0);
	}

	@Override
	// Convert query response to list of objects
	public List<BookingPayment> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<BookingPayment> bookingPayments = new ArrayList<>();
		BookingDAO bdao = new BookingDAO(conn);
		while (results.next()) {
			BookingPayment bookingPayment = new BookingPayment();
			bookingPayment.setBooking(bdao.getBooking(results.getInt("booking_id")));
			bookingPayment.setStripe(results.getString("stripe_id"));
			bookingPayment.setRefunded(results.getInt("refunded"));
			bookingPayments.add(bookingPayment);
		}
		return bookingPayments;
	}

}
