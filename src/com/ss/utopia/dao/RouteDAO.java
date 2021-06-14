package com.ss.utopia.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.utopia.domain.Route;

public class RouteDAO extends BaseDAO<Route> {

	// Constructor with connection
	public RouteDAO(Connection conn) {
		super(conn);
	}

	// Add sql statement given a route
	public void addRoute(Route route) throws ClassNotFoundException, SQLException {
		save("insert into route (?, ?)", new Object[] { route.getOriginAirport().getAirportCode(),
				route.getDestinationAirport().getAirportCode() });
	}

	// Update sql statement given a route
	public void updateRoute(Route route) throws ClassNotFoundException, SQLException {
		save("update route set origin_id = ? " + "and destination_id = ? where id = ?",
				new Object[] { route.getOriginAirport().getAirportCode(),
						route.getDestinationAirport().getAirportCode(), route.getId() });
	}

	// Delete Sql statement given a route
	public void deleteRoute(Route route) throws ClassNotFoundException, SQLException {
		save("delete from route where id = ?", new Object[] { route.getId() });
	}

	// Read Sql statement given a route
	public List<Route> readAllRoutes() throws ClassNotFoundException, SQLException {
		return read("select * from route", null);
	}

	// Read Sql statement with code given a route
	public List<Route> readRoutesByAirportCode(String airportCode) throws ClassNotFoundException, SQLException {
		return read("select * from route where destination_id = ? or origin_id = ?",
				new Object[] { airportCode, airportCode });
	}
	
	// Get a route given id Sql statement given a route
	public Route getRoute(Integer id) throws ClassNotFoundException, SQLException {
		List<Route> routes = read("select * from route where id = ?", new Object[] { id });

		return routes.get(0);
	}

	@Override
	// Convert query response to list of objects
	public List<Route> extractData(ResultSet results) throws ClassNotFoundException, SQLException {
		List<Route> routes = new ArrayList<>();
		AirportDAO adao = new AirportDAO(conn);
		while (results.next()) {
			Route route = new Route();
			route.setId(results.getInt("id"));
			route.setOriginAirport(adao.getAirport(results.getString("origin_id")));
			route.setDestinationAirport(adao.getAirport(results.getString("destination_id")));
			routes.add(route);
		}
		return routes;
	}

}
