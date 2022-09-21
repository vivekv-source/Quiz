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
			if(result) {
				break;
			}
			else {
				System.out.println(res.getString("Please enter correct username"));
				String username1 = sc.nextLine();
				boolean result1 = username.equals(res.getString("username"));
				if(result1) {
					break;
				}
			}
		}
	
		System.out.println(res.getString("username"));
		System.out.println(res.getString("password"));
		
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


	


