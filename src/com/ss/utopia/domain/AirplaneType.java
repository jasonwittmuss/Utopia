package com.ss.utopia.domain;

public class AirplaneType implements Base {
	// class variables
	private Integer id;
	private Integer maxCapacity;

	// Getter and setter methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	@Override
	// Overriding the toString function
	public String toString() {
		return "AirplaneType [id=" + id + ", maxCapacity=" + maxCapacity + "]";
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
