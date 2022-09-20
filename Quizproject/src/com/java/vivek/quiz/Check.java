package com.java.vivek.quiz;

import java.util.Scanner;

public class Check {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("===========================================================================");
		System.out.println("============================Welcome to Quiz================================");
		System.out.println("Do you want to register or login");
		System.out.println("1. Register");
		System.out.println("2. Login");
		int a1 = s.nextInt();
		if(a1==1) {
			Student.studentRegistry();
		}
		else if(a1==2) {
			System.out.println("Please Login");
		}
		System.out.println("Press 1 to continue to login");
		int a2 = s.nextInt();
		if(a2==1) {
			Login l = new Login();
			l.getLoginDetails();
			Answer as= new Answer();
			as.getQuestions();
		}
		else {
			System.out.println("Invalid input");
			System.out.println("Please enter correct input");
			a2=s.nextInt();
		}
		
		{
			System.out.println("Invalid input");
			System.out.println("Please enter correct input");
			a2=s.nextInt();
		}
		
	}

}
