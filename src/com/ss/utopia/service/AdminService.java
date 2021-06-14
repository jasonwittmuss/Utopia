package com.ss.utopia.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ss.utopia.dao.AirplaneDAO;
import com.ss.utopia.dao.AirplaneTypeDAO;
import com.ss.utopia.dao.AirportDAO;
import com.ss.utopia.dao.BookingDAO;
import com.ss.utopia.dao.FlightDAO;
import com.ss.utopia.dao.PassengerDAO;
import com.ss.utopia.dao.RouteDAO;
import com.ss.utopia.dao.UserDAO;
import com.ss.utopia.domain.Airplane;
import com.ss.utopia.domain.AirplaneType;
import com.ss.utopia.domain.Airport;
import com.ss.utopia.domain.Booking;
import com.ss.utopia.domain.Flight;
import com.ss.utopia.domain.Passenger;
import com.ss.utopia.domain.Route;
import com.ss.utopia.domain.User;

public class AdminService {

	// Start a connection
	ConnectionUtil connUtil = new ConnectionUtil();

	// Add route to database given route object
	public void addRoute(Route route) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);

			rdao.addRoute(route);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	

	// List all airplanes from database
	public List<Airplane> readAirplanes() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneDAO adao = new AirplaneDAO(conn);
			List<Airplane> airplanes = adao.readAllAirplane();

			return airplanes;

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}

		return null;
	}
	
	// List all airplane types from database
	public List<AirplaneType> readAirplaneTypes() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirplaneTypeDAO atdao = new AirplaneTypeDAO(conn);
			List<AirplaneType> airplaneTypes = atdao.readAllAirplaneType();

			return airplaneTypes;

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}

		return null;
	}
	
	// List all routes from database
	public List<Route> readRoutes() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			RouteDAO rdao = new RouteDAO(conn);
			List<Route> routes = rdao.readAllRoutes();

			return routes;

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}

		return null;
	}
	
	
	
	
	
	// FLIGHT SERVICE METHODS
	// Add flight given flight object
	public void addFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			fdao.addFlight(flight);

			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	// Update flight given flight object
	public void updateFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			fdao.updateFlight(flight);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	// Delete flight given flight object
	public void deleteFlight(Flight flight) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			fdao.deleteFlight(flight);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	// List all flights
	public List<Flight> readFlights() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			FlightDAO fdao = new FlightDAO(conn);
			List<Flight> flights = fdao.readAllFlight();

			return flights;

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}

		return null;
	}
	
	
	
	
	
	// BOOKING SERVICE METHODS
	// Add booking given flight object
	public void addBooking(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
			bdao.addBooking(booking);

			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	// Update booking given booking object
	public void updateBooking(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
			bdao.updateBooking(booking);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	// Delete booking given booking object
	public void deleteBooking(Booking booking) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
			bdao.deleteBooking(booking);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	// List all bookings
	public List<Booking> readBookings() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			BookingDAO bdao = new BookingDAO(conn);
			List<Booking> bookings = bdao.readAllBookings();

			return bookings;

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}

		return null;
	}
	
	
	
	
	// PASSENGER SERVICE METHODS
	// Add passenger given flight object
	public void addPassenger(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			pdao.addPassenger(passenger);

			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	// Update passenger given passenger object
	public void updatePassenger(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			pdao.updatePassenger(passenger);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	// Delete passenger given passenger object
	public void deletePassenger(Passenger passenger) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			PassengerDAO pdao = new PassengerDAO(conn);
			pdao.deletePassenger(passenger);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	// List all passenger
	public List<Passenger> readPassenger() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();

			PassengerDAO pdao = new PassengerDAO(conn);
			List<Passenger> users = pdao.readAllPassengers();

			return users;

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}

		return null;
	}
	
	
	
	
	
	// AIRPORT SERVICE METHODS
	// Add airport given flight object
	public void addAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDAO adao = new AirportDAO(conn);
			adao.addAirport(airport);

			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	// Update airport given airport object
	public void updateAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDAO adao = new AirportDAO(conn);
			adao.updateAirport(airport);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	// Delete airport given airport object
	public void deleteAirport(Airport airport) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AirportDAO adao = new AirportDAO(conn);
			adao.deleteAirport(airport);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	// List all airport
	public List<Airport> readAirport() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();

			AirportDAO adao = new AirportDAO(conn);
			List<Airport> users = adao.readAllAirport();

			return users;

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}

		return null;
	}
	
	
	
	
	// USER SERVICE METHODS
	// Add user given flight object
	public void addUser(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);
			udao.addUser(user);

			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
			
	// Update user given user object
	public void updateUser(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);

			udao.updateUser(user);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	// Delete user given user object
	public void deleteUser(User user) throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			UserDAO udao = new UserDAO(conn);

			udao.deleteUser(user);

			conn.commit();

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	// List all user
	public List<User> readUsers() throws SQLException {
		Connection conn = null;
		try {
			conn = connUtil.getConnection();

			UserDAO udao = new UserDAO(conn);
			List<User> users = udao.readAllUsers();

			return users;

		} catch (Exception e) {
			conn.rollback();
		} finally {
			conn.close();
		}

		return null;
	}

	

}
