package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.domain.FlightBookings;

public class FlightBookingDAO extends BaseDAO<FlightBookings> {

	// Constructor with connection
	public FlightBookingDAO(Connection conn) {
		super(conn);
	}

	// Add sql statement given a flight booking
	public void addFlightBooking(FlightBookings flightBooking) throws ClassNotFoundException, SQLException {
		save("insert into flight_booking (?, ?)",
				new Object[] { flightBooking.getFlight().getId(), flightBooking.getBooking().getId() });
	}

	// Update sql statement given a flight booking
	public void updateFlightBooking(FlightBookings flightBooking) throws ClassNotFoundException, SQLException {
		save("update flight_booking set flgiht_id = ? where booking_id = ?",
				new Object[] { flightBooking.getFlight().getId(), flightBooking.getBooking().getId() });
	}

	// Delete Sql statement given a flight booking
	public void deleteFlightBooking(FlightBookings flightBooking) throws ClassNotFoundException, SQLException {
		save("delete from flight_booking where booking_id = ?", new Object[] { flightBooking.getBooking().getId() });
	}

	// Read Sql statement given a flight booking
	public List<FlightBookings> readAllFlightBookings() throws ClassNotFoundException, SQLException {
		return read("select * from flight_booking", null);
	}

	// Get a flight booking given id Sql statement given a 
	public FlightBookings getFlightBooking(Integer id) throws ClassNotFoundException, SQLException {
		List<FlightBookings> routes = read("select * from flight_booking where booking_id = ?", new Object[] { id });

		return routes.get(0);
	}

	@Override
	// Convert query response to list of objects
	public List<FlightBookings> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<FlightBookings> flightBookings = new ArrayList<>();
		FlightDAO fdao = new FlightDAO(conn);
		BookingDAO bdao = new BookingDAO(conn);
		while (results.next()) {
			FlightBookings flightBooking = new FlightBookings();
			flightBooking.setFlight(fdao.getFlight(results.getInt("flight_id")));
			flightBooking.setBooking(bdao.getBooking(results.getInt("booking_id")));
			flightBookings.add(flightBooking);
		}
		return flightBookings;
	}

}
