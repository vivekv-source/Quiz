package com.java.vivek.quiz;

import java.util.Scanner;

public class Score {
	

	public void runMethod() {
		Login l = new Login();
		Scanner s = new Scanner(System.in);
		{
			System.out.println("===========================================================================");
			System.out.println("============================Welcome to Java Quiz================================");
			System.out.println("===========================================================================");

			System.out.println("Do you want to register or login");
			System.out.println("Press 1 for Registration or Press 2 for Login");

			System.out.println("1. Register");
			System.out.println("2. Login");
			int a1 = s.nextInt();
			// s.next();
			if (a1 == 1) {
				UserRegistration.studentRegistry();
			} else if (a1 == 2) {
				System.out.println("Please Login");
				l.getLoginDetails();
			} 
			
		}
	}

}