package com.ss.utopia.jdbc;

import java.util.Scanner;

public class MainMenu {
	// Start calling the first menu
	public static void main(String[] args)  {
		firstMenu();
	}
	
	// Determine user type
	public static void firstMenu() {
		System.out.println("1) Agent");
		System.out.println("2) Administrator");
		System.out.println("3) Traveler");
		
		int selector = 0;
		
		Scanner input = new Scanner(System.in);
		
		selector = input.nextInt();
		
		// Switch and call the relevant class to open the appropriate menu
		switch(selector) {
		case 1: 
			AgentMenus agentMenu = new AgentMenus();
			agentMenu.menuEmp1();
			break;
		case 2: 
			AdminMenus adminMenu = new AdminMenus();
			adminMenu.menuAdmin();
			break;
		case 3: 
			TravMenus travMenu = new TravMenus();
			travMenu.menuTrav();
			break;
		default: 
			System.out.println("Incorrect Selection");
			break;
		}
		
		input.close();
	}
}
