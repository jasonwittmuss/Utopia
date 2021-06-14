package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.domain.BookingGuest;

public class BookingGuestDAO extends BaseDAO<BookingGuest> {

	// Constructor with connection
	public BookingGuestDAO(Connection conn) {
		super(conn);
	}

	// Add sql statement given a booking guest
	public void addBookingGuest(BookingGuest bookingGuest) throws ClassNotFoundException, SQLException {
		save("insert into booking_guest (?, ?, ?)",
				new Object[] { bookingGuest.getBooking().getId(), bookingGuest.getEmail(), bookingGuest.getPhone() });
	}

	// Update sql statement given a booking guest
	public void updateBookingGuest(BookingGuest bookingGuest) throws ClassNotFoundException, SQLException {
		save("update booking_guest set contact_email = ? and contact_phone = ? where booking_id = ?",
				new Object[] { bookingGuest.getEmail(), bookingGuest.getPhone(), bookingGuest.getBooking().getId() });
	}

	// Delete Sql statement given a booking guest
	public void deleteBookingGuest(BookingGuest bookingGuest) throws ClassNotFoundException, SQLException {
		save("delete from booking_guest where booking_id = ?", new Object[] { bookingGuest.getBooking().getId() });
	}

	// Read Sql statement given a booking guest
	public List<BookingGuest> readAllBookingGuests() throws ClassNotFoundException, SQLException {
		return read("select * from booking_guest", null);
	}

	// Get a booking guest given id Sql statement given a 
	public BookingGuest getBookingGuest(Integer id) throws ClassNotFoundException, SQLException {
		List<BookingGuest> bookingGuests = read("select * from booking_guest where booking_id = ?",
				new Object[] { id });

		return bookingGuests.get(0);
	}

	@Override
	// Convert query response to list of objects
	public List<BookingGuest> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<BookingGuest> bookingGuests = new ArrayList<>();
		BookingDAO bdao = new BookingDAO(conn);
		while (results.next()) {
			BookingGuest bookingGuest = new BookingGuest();
			bookingGuest.setBooking(bdao.getBooking(results.getInt("booking_id")));
			bookingGuest.setEmail(results.getString("contact_email"));
			bookingGuest.setPhone(results.getString("contact_phone"));
			bookingGuests.add(bookingGuest);
		}
		return bookingGuests;
	}

}
