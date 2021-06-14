package com.ss.utopia.domain;

public class Airplane implements Base {
	// class variables
	private Integer id;
	private AirplaneType type;

	// Getter and setter methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AirplaneType getType() {
		return type;
	}

	public void setType(AirplaneType type) {
		this.type = type;
	}

	@Override
	// Overriding the toString function
	public String toString() {
		return "Airplane [id=" + id + ", type=" + type + "]";
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
		// TODO Auto-generated method stub
		
	}

}
