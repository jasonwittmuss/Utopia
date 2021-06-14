package com.ss.utopia.tests;

import org.junit.jupiter.api.Test;

import com.ss.utopia.domain.Airport;

class AirportTest {

	@Test
	void test() {
		Airport airport = new Airport();
		airport.setAirportCode("LAX");
		airport.setCity("Los Angeles");
		
		System.out.println(airport);
		
		airport.getAirportCode();
		airport.getCity();
		
		// airport.adminSelectAdd();
		// airport.adminSelectUpdate();
		// airport.adminSelectDelete();
		airport.adminSelectRead();
	}

}
