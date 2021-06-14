package com.ss.utopia.tests;

import org.junit.jupiter.api.Test;

import com.ss.utopia.domain.AirplaneType;

class AirplaneTypeTest {

	@Test
	void test() {
		AirplaneType airplaneType = new AirplaneType();
		airplaneType.setId(1);
		airplaneType.setMaxCapacity(40);
		
		System.out.println(airplaneType);
		
		airplaneType.getId();
		airplaneType.getMaxCapacity();
		
		airplaneType.adminSelectAdd();
		airplaneType.adminSelectUpdate();
		airplaneType.adminSelectDelete();
		airplaneType.adminSelectRead();
	}

}
