package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.domain.AirplaneType;

public class AirplaneTypeDAO extends BaseDAO<AirplaneType> {

	// Constructor with connection
	public AirplaneTypeDAO(Connection conn) {
		super(conn);
	}

	// Add sql statement given a airplane type
	public void addAirplaneType(AirplaneType airplaneType) throws ClassNotFoundException, SQLException {
		save("insert into airplane_type (?, ?)", new Object[] { airplaneType.getId(), airplaneType.getMaxCapacity() });
	}

	// Update sql statement given a airplane type
	public void updateAirplaneType(AirplaneType airplaneType) throws ClassNotFoundException, SQLException {
		save("update airplane_type set max_capacity = ? where iata_id = ?",
				new Object[] { airplaneType.getMaxCapacity(), airplaneType.getId() });
	}

	// Delete Sql statement given a airplane type
	public void deleteAirplaneType(AirplaneType airplaneType) throws ClassNotFoundException, SQLException {
		save("delete from airplane_type where id = ?", new Object[] { airplaneType.getId() });
	}

	// Read Sql statement given a airplane type
	public List<AirplaneType> readAllAirplaneType() throws ClassNotFoundException, SQLException {
		return read("select * from airplane_type", null);
	}

	// Get a airplane type given id Sql statement given a airplane type
	public AirplaneType getAirplaneType(Integer id) throws ClassNotFoundException, SQLException {
		List<AirplaneType> airplaneTypes = read("select * from airplane_type where id = ?", new Object[] { id });

		return airplaneTypes.get(0);
	}

	@Override
	// Convert query response to list of objects
	public List<AirplaneType> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<AirplaneType> airplaneTypes = new ArrayList<>();
		while (results.next()) {
			AirplaneType airplaneType = new AirplaneType();
			airplaneType.setId(results.getInt("id"));
			airplaneType.setMaxCapacity(results.getInt("max_capacity"));
			airplaneTypes.add(airplaneType);
		}
		return airplaneTypes;
	}

}
