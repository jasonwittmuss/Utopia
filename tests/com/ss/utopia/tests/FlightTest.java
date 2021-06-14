package com.ss.utopia.tests;

import org.junit.jupiter.api.Test;

import com.ss.utopia.domain.Flight;
import com.ss.utopia.domain.Route;
import com.ss.utopia.domain.Airplane;

class FlightTest {

	@Test
	void test() {
		Flight flight = new Flight();
		flight.setId(1);
		flight.setRoute(new Route());
		flight.setPlane(new Airplane());
		flight.setTime("12:00");
		flight.setReservedSeats(200);
		flight.setPrice((float) 100.0);
		
		System.out.println(flight);
		
		flight.getId();
		flight.getRoute();
		flight.getPlane();
		flight.getTime();
		flight.getReservedSeats();
		flight.getPrice();
		
		// flight.adminSelectAdd();
		// flight.adminSelectUpdate();
		// flight.adminSelectDelete();
		flight.adminSelectRead();
	}

}
