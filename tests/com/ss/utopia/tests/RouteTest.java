package com.ss.utopia.tests;

import org.junit.jupiter.api.Test;

import com.ss.utopia.domain.Airport;
import com.ss.utopia.domain.Route;

class RouteTest {

	@Test
	void test() {
		Route route = new Route();
		route.setId(1);
		route.setOriginAirport(new Airport());
		route.setDestinationAirport(new Airport());
		
		System.out.println(route);
		
		route.getId();
		route.getOriginAirport();
		route.getDestinationAirport();
		
		route.adminSelectAdd();
		route.adminSelectUpdate();
		route.adminSelectDelete();
		route.adminSelectRead();
	}

}
