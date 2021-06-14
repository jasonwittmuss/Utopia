package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.domain.BookingUser;

public class BookingUserDAO extends BaseDAO<BookingUser> {

	// Constructor with connection
	public BookingUserDAO(Connection conn) {
		super(conn);
	}

	// Add sql statement given a booking user
	public void addBookingUser(BookingUser bookingUser) throws ClassNotFoundException, SQLException {
		save("insert into booking_user (?, ?)",
				new Object[] { bookingUser.getBooking().getId(), bookingUser.getUser().getId() });
	}

	// Update sql statement given a booking user
	public void updateBookingUser(BookingUser bookingUser) throws ClassNotFoundException, SQLException {
		save("update booking_user set user_id = ? where booking_id = ?",
				new Object[] { bookingUser.getUser().getId(), bookingUser.getBooking().getId() });
	}

	// Delete Sql statement given a booking user
	public void deleteBookingUser(BookingUser bookingUser) throws ClassNotFoundException, SQLException {
		save("delete from booking_user where booking_id = ?", new Object[] { bookingUser.getBooking().getId() });
	}

	// Read Sql statement given a booking user
	public List<BookingUser> readAllBookingUsers() throws ClassNotFoundException, SQLException {
		return read("select * from booking_user", null);
	}

	// Get a booking user given id Sql statement given a 
	public BookingUser getBookingUser(Integer id) throws ClassNotFoundException, SQLException {
		List<BookingUser> routes = read("select * from booking_user where booking_id = ?", new Object[] { id });

		return routes.get(0);
	}

	@Override
	// Convert query response to list of objects
	public List<BookingUser> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<BookingUser> bookingUsers = new ArrayList<>();
		BookingDAO bdao = new BookingDAO(conn);
		UserDAO udao = new UserDAO(conn);
		while (results.next()) {
			BookingUser bookingUser = new BookingUser();
			bookingUser.setBooking(bdao.getBooking(results.getInt("booking_id")));
			bookingUser.setUser(udao.getUser(results.getInt("user_id")));
			bookingUsers.add(bookingUser);
		}
		return bookingUsers;
	}

}
