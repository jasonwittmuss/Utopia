package com.ss.utopia.domain;

// Used as interface for objects to help the menu selection
public interface Base {
	// Gets proper information for user to add
	public void adminSelectAdd();
	
	// Gets proper information for user to update
	public void adminSelectUpdate();

	// Gets proper information for user to delete
	public void adminSelectDelete();

	// Gets proper information for user to add
	public void adminSelectRead();
}

