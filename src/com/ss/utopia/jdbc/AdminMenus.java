package com.ss.utopia.jdbc;

import java.util.Scanner;

import com.ss.utopia.domain.Airport;
import com.ss.utopia.domain.Base;
import com.ss.utopia.domain.Booking;
import com.ss.utopia.domain.Flight;
import com.ss.utopia.domain.Passenger;
import com.ss.utopia.domain.User;

public class AdminMenus {
	// Menu when admin is selected
	public AdminMenus() {
	}

	public void menuAdmin() {
		System.out.println("1) Add/Update/Delete/Read Flights");
		System.out.println("2) Add/Update/Delete/Read Bookings");
		System.out.println("3) Add/Update/Delete/Read Passengers");
		System.out.println("4) Add/Update/Delete/Read Airports");
		System.out.println("5) Add/Update/Delete/Read Travelers");
		System.out.println("6) Add/Update/Delete/Read Employees");
		System.out.println("7) Over-ride Trip Cancellation for a ticket");
		System.out.println("8) Return to Main Menu");
		
		// selector is which thing to edit and operator is what operation to do
		int selector = 0;
		int operator = 0;

		Scanner input = new Scanner(System.in);
		
		selector = input.nextInt();
		
		// Return to main menu
		if(selector == 8) {
			MainMenu.firstMenu();
			input.close();
			return;
		}
		
		System.out.println("1) Add");
		System.out.println("2) Update");
		System.out.println("3) Delete");
		System.out.println("4) Read");
		System.out.println("5) Return to Main Menu");
		
		operator = input.nextInt();
		
		// After getting inputs, call helper command
		selectAdminCommand(selector, operator);

		input.close();

	}

	private void selectAdminCommand(int selector, int operator) {
		// Use interface base to polymorphically call the operator on the selector's class
		Base obj;
		switch(selector) {
		case 1:
			obj = new Flight();
			break;
		case 2:
			obj = new Booking();
			break;
		case 3:
			obj = new Passenger();
			break;
		case 4:
			obj = new Airport();
			break;
		case 5:
			obj = new User();
			break;
		case 6:
			obj = new User();
			break;
		case 7:
			overRide();
			return;
		default:
			MainMenu.firstMenu();
			return;
		}
			
		switch(operator) {
		case 1:
			obj.adminSelectAdd();
			break;
		case 2:
			obj.adminSelectUpdate();
			break;
		case 3:
			obj.adminSelectDelete();
			break;
		case 4:
			obj.adminSelectRead();
			break;
		default:
			MainMenu.firstMenu();
			return;
		}
		
	}
	
	// Over-ride Trip Cancellation for a ticket
	private void overRide() {
		// TODO: Add override stuff
		
	}

}
