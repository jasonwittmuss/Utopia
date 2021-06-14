package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.domain.Airport;

public class AirportDAO extends BaseDAO<Airport> {

	// Constructor with connection
	public AirportDAO(Connection conn) {
		super(conn);
	}

	// Add sql statement given a airport
	public void addAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("insert into airport values (?, ?)", new Object[] { airport.getAirportCode(), airport.getCity() });
	}

	// Update sql statement given a airport
	public void updateAirport(Airport airport) throws ClassNotFoundException, SQLException {
		save("update airport set city = ? where iata_id = ?",
				new Object[] { airport.getCity(), airport.getAirportCode() });
	}

	// Delete Sql statement given a airport
	public void deleteAirport(Airport Airport) throws ClassNotFoundException, SQLException {
		save("delete from airport where iata_id = ?", new Object[] { Airport.getAirportCode() });
	}

	// Read Sql statement given a airport
	public List<Airport> readAllAirport() throws ClassNotFoundException, SQLException {
		return read("select * from airport", null);
	}
	
	// Get a airport given id Sql statement given a airport
	public Airport getAirport(String code) throws ClassNotFoundException, SQLException {
		List<Airport> airports = read("select * from airport where iata_id = ?", new Object[] { code });

		return airports.get(0);
	}

	@Override
	// Convert query response to list of objects
	public List<Airport> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<Airport> airports = new ArrayList<>();
		while (results.next()) {
			Airport airport = new Airport();
			airport.setAirportCode(results.getString("iata_id"));
			airport.setCity(results.getString("city"));
			airports.add(airport);
		}
		return airports;
	}

}
