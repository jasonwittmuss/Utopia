package com.ss.utopia.domain;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ss.utopia.service.AdminService;

public class Flight implements Base {
	// class variables
	private Integer id;
	private Route route;
	private Airplane plane;
	private String time;
	private Integer reservedSeats;
	private Float price;

	// Getter and setter methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Airplane getPlane() {
		return plane;
	}

	public void setPlane(Airplane plane) {
		this.plane = plane;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String date) {
		this.time = date;
	}

	public Integer getReservedSeats() {
		return reservedSeats;
	}

	public void setReservedSeats(Integer reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	// Overriding the toString function
	public String toString() {
		return "Flight [id=" + id + ", route=" + route + ", plane=" + plane + ", time=" + time + ", reservedSeats="
				+ reservedSeats + ", price=" + price + "]";
	}

	@Override
	// Administrator adding an element to the database
	public void adminSelectAdd() {
		Flight flight = new Flight();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Flight ID: ");
		flight.setId(Integer.parseInt(input.nextLine()));
		
		System.out.print("Airplane ID: ");
		flight.setRoute(new Route());
		flight.getRoute().setId(Integer.parseInt(input.nextLine()));
		
		System.out.print("Plane ID: ");
		flight.setPlane(new Airplane());
		flight.getPlane().setId(Integer.parseInt(input.nextLine()));
		
		System.out.print("Time: ");
		flight.setTime(input.nextLine());
		
		System.out.print("Seats: ");
		flight.setReservedSeats(Integer.parseInt(input.nextLine()));
		
		System.out.print("Price: ");
		flight.setPrice(Float.parseFloat(input.nextLine()));
		
		AdminService admin = new AdminService();
		try {
			admin.addFlight(flight);
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		
		input.close();
	}

	@Override
	// Administrator updating an element to the database
	public void adminSelectUpdate() {
		Flight flight = new Flight();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Flight ID: ");
		flight.setId(Integer.parseInt(input.nextLine()));
		
		System.out.print("Airplane ID: ");
		flight.setRoute(new Route());
		flight.getRoute().setId(Integer.parseInt(input.nextLine()));
		
		System.out.print("Role (1-Administrator, 2-Agent, 3-User): ");
		flight.setPlane(new Airplane());
		flight.getPlane().setId(Integer.parseInt(input.nextLine()));
		
		System.out.print("Username: ");
		flight.setTime(input.nextLine());
		
		System.out.print("Password: ");
		flight.setReservedSeats(Integer.parseInt(input.nextLine()));
		
		System.out.print("Email: ");
		flight.setPrice(Float.parseFloat(input.nextLine()));
		
		AdminService admin = new AdminService();
		try {
			admin.updateFlight(flight);
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		
		input.close();
	}

	@Override
	// Administrator deleting an element to the database
	public void adminSelectDelete() {
		Flight flight = new Flight();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Flight ID: ");
		flight.setId(Integer.parseInt(input.nextLine()));
		
		
		AdminService admin = new AdminService();
		try {
			admin.deleteFlight(flight);
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
			List<Flight> flights = admin.readFlights();
			for (Flight flight : flights) {
				System.out.println(flight);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
