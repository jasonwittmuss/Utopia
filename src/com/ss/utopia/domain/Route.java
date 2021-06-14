package com.ss.utopia.domain;

import java.sql.SQLException;
import java.util.List;

import com.ss.utopia.service.AdminService;

public class Route implements Base {
	// class variables
	private Integer id;
	private Airport originAirport;
	private Airport destinationAirport;

	// Getter and setter methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Airport getOriginAirport() {
		return originAirport;
	}

	public void setOriginAirport(Airport originAirport) {
		this.originAirport = originAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	@Override
	// Overriding the toString function
	public String toString() {
		return "Route [id=" + id + ", originAirport=" + originAirport + ", destinationAirport=" + destinationAirport
				+ "]";
	}
	
	// Below are not used by my current implementation

	@Override
	public void adminSelectAdd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adminSelectUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adminSelectDelete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adminSelectRead() {
		AdminService admin = new AdminService();
		try {
			List<Route> routes = admin.readRoutes();
			for (Route route : routes) {
				System.out.println(route);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
