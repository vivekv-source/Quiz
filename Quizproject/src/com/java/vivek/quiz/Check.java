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
		System.out.println("===========================================================================");
		int a1 = s.nextInt();
		if(a1==1) {
			System.out.println("===========================================================================");
			System.out.println("Please enter the below details to Register");
			Student.studentRegistry();
			System.out.println("Press 1 to proceed to login");
			int a3 = s.nextInt();
			if(a3==1) {
				System.out.println("Please enter the below details to Login");
				Login l = new Login();
				l.getLoginDetails();	
			}
			else {
				System.out.println("Invalid Input");
				System.out.println("Please enter correct input");
				int a4 = s.nextInt();
				if(a4==1) {
					System.out.println("Please enter the below details to Login");
					Login l = new Login();
					l.getLoginDetails();	
				}
			}
			
			
		}
		else if(a1==2){
			System.out.println("Please enter the below details to Login");
			Login l = new Login();
			l.getLoginDetails();
		}
		else {
			System.out.println("Invalid Input");
			System.out.println("Please enter correct input");
			System.out.println("1. Register");
			System.out.println("2. Login");
			int a2 = s.nextInt();
			if(a2==1) {
				System.out.println("Please enter the below details to Register");
				Student.studentRegistry();
			}
		}
		
	}

}
