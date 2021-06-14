package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.domain.Booking;

public class BookingDAO extends BaseDAO<Booking> {

	// Constructor with connection
	public BookingDAO(Connection conn) {
		super(conn);
	}

	// Add sql statement given a booking
	public void addBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("insert into booking values (?, ?, ?)",
				new Object[] { booking.getId(), booking.getIsActive(), booking.getConfirmationCode() });
	}

	// Update sql statement given a booking
	public void updateBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("update booking set is_active = ? and confirmation_code = ? where id = ?",
				new Object[] { booking.getIsActive(), booking.getConfirmationCode(), booking.getId() });
	}

	// Delete Sql statement given a booking
	public void deleteBooking(Booking booking) throws ClassNotFoundException, SQLException {
		save("delete from booking where id = ?", new Object[] { booking.getId() });
	}

	// Read Sql statement given a booking
	public List<Booking> readAllBookings() throws ClassNotFoundException, SQLException {
		return read("select * from booking", null);
	}

	// Get a booking given id Sql statement given a booking
	public Booking getBooking(Integer id) throws ClassNotFoundException, SQLException {
		List<Booking> bookings = read("select * from booking where id = ?", new Object[] { id });

		return bookings.get(0);
	}

	@Override
	// Convert query response to list of objects
	public List<Booking> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<Booking> bookings = new ArrayList<>();
		while (results.next()) {
			Booking booking = new Booking();
			booking.setId(results.getInt("id"));
			booking.setIsActive(results.getInt("is_active"));
			booking.setConfirmationCode(results.getString("confirmation_code"));
			bookings.add(booking);
		}
		return bookings;
	}

}