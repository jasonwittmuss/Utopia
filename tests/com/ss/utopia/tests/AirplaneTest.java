package com.ss.utopia.tests;

import org.junit.jupiter.api.Test;

import com.ss.utopia.domain.Airplane;
import com.ss.utopia.domain.AirplaneType;

class AirplaneTest {

	@Test
	void test() {
		Airplane airplane = new Airplane();
		airplane.setId(1);
		airplane.setType(new AirplaneType());
		
		System.out.println(airplane);
		
		airplane.getId();
		airplane.getType();
		
		airplane.adminSelectAdd();
		airplane.adminSelectUpdate();
		airplane.adminSelectDelete();
		airplane.adminSelectRead();
	}

}
