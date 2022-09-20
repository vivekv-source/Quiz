package com.java.vivek.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Login {
	
	Connection c = null;
	PreparedStatement p1 = null;
	

	public void getLoginDetails() {
	try {
		Scanner sc =new Scanner(System.in);
		ConnectionTest test = new ConnectionTest();
		c=test.getConnection();
		p1=c.prepareStatement("select * from student ");
		ResultSet res = p1.executeQuery();
		while(res.next()) {
			
			System.out.println("Enter your username");
			String username = sc.nextLine();
	
			boolean result = username.equals(res.getString("username"));
			System.out.println(result);
			if(result) {
				System.out.println("Enter your password");
			String password =sc.nextLine();
			boolean result1 = password.equals(res.getString("password"));
			if(result1) {
				System.out.println("Press 1 to start the quiz");
			}
			else {
				System.out.println("password is incorrect ");
				System.out.println("Please enter correct password");
				password = sc.nextLine();
				result1 = password.equals(res.getString("password"));
	   		}
	            }
			else {
				System.out.println("Invalid username");
				System.out.println("Please enter correct username");
			}
			
		}
		
	}	
	catch (Exception e) {
		e.printStackTrace();
	}	
	}
	public static void main(String[] args) {
		Login l = new Login();
		l.getLoginDetails();
		
		
	}
}


	


