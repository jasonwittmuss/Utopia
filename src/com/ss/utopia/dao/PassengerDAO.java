package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.domain.Passenger;

public class PassengerDAO extends BaseDAO<Passenger> {

	// Constructor with connection
	public PassengerDAO(Connection conn) {
		super(conn);
	}

	// Add sql statement given a passenger
	public void addPassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("insert into passenger values (?, ?, ?, ?, ?, ?, ?)",
				new Object[] { passenger.getId(), passenger.getBooking().getId(), passenger.getGivenName(),
						passenger.getFamilyName(), passenger.getDob(), passenger.getGender(), passenger.getAddress() });
	}

	// Update sql statement given a passenger
	public void updatePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("update passenger set booking_id = ? and given_name = ? and family_name = ? and dob = ? and gender = ? and address = ? where id = ?",
				new Object[] { passenger.getBooking().getId(), passenger.getGivenName(), passenger.getFamilyName(),
						passenger.getDob(), passenger.getGender(), passenger.getAddress(), passenger.getId() });
	}

	// Delete Sql statement given a passenger
	public void deletePassenger(Passenger passenger) throws ClassNotFoundException, SQLException {
		save("delete from passenger where id = ?", new Object[] { passenger.getId() });
	}

	// Read Sql statement given a passenger
	public List<Passenger> readAllPassengers() throws ClassNotFoundException, SQLException {
		return read("select * from passenger", null);
	}

	// Get a passenger given id Sql statement given a passenger
	public Passenger getPassenger(Integer id) throws ClassNotFoundException, SQLException {
		List<Passenger> routes = read("select * from passenger where id = ?", new Object[] { id });

		return routes.get(0);
	}

	@Override
	// Convert query response to list of objects
	public List<Passenger> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<Passenger> passengers = new ArrayList<>();
		BookingDAO bdao = new BookingDAO(conn);
		while (results.next()) {
			Passenger passenger = new Passenger();
			passenger.setId(results.getInt("id"));
			passenger.setBooking(bdao.getBooking(results.getInt("booking_id")));
			passenger.setGivenName(results.getString("given_name"));
			passenger.setFamilyName(results.getString("family_name"));
			passenger.setDob(results.getString("dob"));
			passenger.setGender(results.getString("gender"));
			passenger.setAddress(results.getString("address"));
			passengers.add(passenger);
		}
		return passengers;
	}

}