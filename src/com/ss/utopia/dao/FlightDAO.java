package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.domain.Flight;

public class FlightDAO extends BaseDAO<Flight> {

	// Constructor with connection
	public FlightDAO(Connection conn) {
		super(conn);
	}

	// Add sql statement given a flight
	public void addFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("insert into flight values (?, ?, ?, ?, ?, ?)", new Object[] { flight.getId(), flight.getRoute(),
				flight.getPlane(), flight.getTime(), flight.getReservedSeats(), flight.getPrice() });
	}

	// Update sql statement given a flight
	public void updateFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("update flight set route_id = ? and airplane_id = ? and departure_time = ? and reserved_seats = ? and seat_price = ? where id = ?",
				new Object[] { flight.getRoute(), flight.getPlane(), flight.getTime(), flight.getReservedSeats(),
						flight.getPrice(), flight.getId() });
	}

	// Delete Sql statement given a flight
	public void deleteFlight(Flight flight) throws ClassNotFoundException, SQLException {
		save("delete from flight where id = ?", new Object[] { flight.getId() });
	}

	// Read Sql statement given a flight
	public List<Flight> readAllFlight() throws ClassNotFoundException, SQLException {
		return read("select * from flight", null);
	}

	// Get a flight given id Sql statement given a flight
	public Flight getFlight(Integer id) throws ClassNotFoundException, SQLException {
		List<Flight> flights = read("select * from flight where id = ?", new Object[] { id });

		return flights.get(0);
	}

	@Override
	// Convert query response to list of objects
	public List<Flight> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<Flight> flights = new ArrayList<>();
		AirplaneDAO adao = new AirplaneDAO(conn);
		RouteDAO rdao = new RouteDAO(conn);
		while (results.next()) {
			Flight flight = new Flight();
			flight.setId(results.getInt("id"));
			flight.setRoute(rdao.getRoute(results.getInt("route_id")));
			flight.setPlane(adao.getAirplane(results.getInt("airplane_id")));
			flight.setTime(results.getString("departure_time"));
			flight.setReservedSeats(results.getInt("reserved_seats"));
			flight.setPrice(results.getFloat("seat_price"));
			flights.add(flight);
		}
		return flights;
	}

}