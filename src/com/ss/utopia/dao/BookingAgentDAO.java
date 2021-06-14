package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.domain.BookingAgent;

public class BookingAgentDAO  extends BaseDAO<BookingAgent> {

	// Constructor with connection
	public BookingAgentDAO(Connection conn) {
		super(conn);
	}

	// Add sql statement given a booking agent
	public void addBookingAgent(BookingAgent bookingAgent) throws ClassNotFoundException, SQLException {
		save("insert into booking_agent (?, ?)", new Object[] { bookingAgent.getBooking().getId(),
				bookingAgent.getUser().getId() });
	}

	// Update sql statement given a booking agent
	public void updateBookingAgent(BookingAgent bookingAgent) throws ClassNotFoundException, SQLException {
		save("update booking_agent set agent_id = ? where booking_id = ?",
				new Object[] { bookingAgent.getUser().getId(), bookingAgent.getBooking().getId() });
	}

	// Delete Sql statement given a booking agent
	public void deleteBookingAgent(BookingAgent bookingAgent) throws ClassNotFoundException, SQLException {
		save("delete from booking_agent where booking_id = ?", new Object[] { bookingAgent.getBooking().getId() });
	}

	// Read Sql statement given a booking agent
	public List<BookingAgent> readAllBookingAgents() throws ClassNotFoundException, SQLException {
		return read("select * from booking_agent", null);
	}
	
	// Get a booking agent given id Sql statement given a 
	public BookingAgent getBookingAgent(Integer id) throws ClassNotFoundException, SQLException {
		List<BookingAgent> bookingAgents = read("select * from booking_agent where booking_id = ?", new Object[] { id });

		return bookingAgents.get(0);
	}

	@Override
	// Convert query response to list of objects
	public List<BookingAgent> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<BookingAgent> bookingAgents = new ArrayList<>();
		BookingDAO bdao = new BookingDAO(conn);
		UserDAO udao = new UserDAO(conn);
		while (results.next()) {
			BookingAgent bookingAgent = new BookingAgent();
			bookingAgent.setBooking(bdao.getBooking(results.getInt("booking_id")));
			bookingAgent.setUser(udao.getUser(results.getInt("agent_id")));
			bookingAgents.add(bookingAgent);
		}
		return bookingAgents;
	}

}
