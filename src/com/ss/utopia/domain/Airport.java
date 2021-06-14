package com.ss.utopia.domain;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.service.AdminService;

public class Airport implements Base {
	// class variables
	private String airportCode;
	private String city;

	// Getter and setter methods
	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	// Overriding the toString function
	public String toString() {
		return "Airport [airportCode=" + airportCode + ", city=" + city + "]";
	}

	@Override
	// Administrator adding an element to the database
	public void adminSelectAdd() {
		Airport airport = new Airport();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Airport Code: ");
		airport.setAirportCode(input.nextLine());
		
		System.out.print("City: ");
		airport.setCity(input.nextLine());
		
		
		
		AdminService admin = new AdminService();
		try {
			admin.addAirport(airport);
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		
		input.close();
	}

	@Override
	// Administrator updating an element to the database
	public void adminSelectUpdate() {
		Airport airport = new Airport();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Airport Code: ");
		airport.setAirportCode(input.nextLine());
		
		System.out.print("City: ");
		airport.setCity(input.nextLine());
		
		
		
		AdminService admin = new AdminService();
		try {
			admin.updateAirport(airport);
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		
		input.close();
		
	}

	@Override
	// Administrator deleting an element to the database
	public void adminSelectDelete() {
		Airport airport = new Airport();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Airport Code: ");
		airport.setAirportCode(input.nextLine());
		
		AdminService admin = new AdminService();
		try {
			admin.deleteAirport(airport);
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		
		input.close();
	}

	@Override
	// Administrator reading all elements to the database
	public void adminSelectRead() {
		AdminService admin = new AdminService();
		try {
			List<Airport> airports = admin.readAirport();
			for (Airport airport : airports) {
				System.out.println(airport);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
