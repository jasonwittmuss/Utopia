package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.domain.Airplane;

public class AirplaneDAO extends BaseDAO<Airplane> {

	// Constructor with connection
	public AirplaneDAO(Connection conn) {
		super(conn);
	}

	// Add sql statement given a airplane
	public void addAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("insert into airplane (?, ?)", new Object[] { airplane.getId(), airplane.getType() });
	}

	// Update sql statement given a airplane
	public void updateAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("update airplane set type_id = ? where id = ?", new Object[] { airplane.getType(), airplane.getId() });
	}

	// Delete Sql statement given a airplane
	public void deleteAirplane(Airplane airplane) throws ClassNotFoundException, SQLException {
		save("delete from airplane where id = ?", new Object[] { airplane.getId() });
	}

	// Read Sql statement given a airplane
	public List<Airplane> readAllAirplane() throws ClassNotFoundException, SQLException {
		return read("select * from airplane", null);
	}

	// Get a airplane given id Sql statement given a airplane
	public Airplane getAirplane(Integer id) throws ClassNotFoundException, SQLException {
		List<Airplane> airplanes = read("select * from airplane where id = ?", new Object[] { id });

		return airplanes.get(0);
	}

	@Override
	// Convert query response to list of objects
	public List<Airplane> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<Airplane> airplanes = new ArrayList<>();
		AirplaneTypeDAO atdao = new AirplaneTypeDAO(conn);
		while (results.next()) {
			Airplane airplane = new Airplane();
			airplane.setId(results.getInt("id"));
			airplane.setType(atdao.getAirplaneType(results.getInt("type_id")));
			airplanes.add(airplane);
		}
		return airplanes;
	}

}
