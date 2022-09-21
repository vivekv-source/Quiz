package com.java.vivek.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserRegistration {

	Connection c = null;
	PreparedStatement p1 = null;

	public void insertStudentData(int id, String firstname, String lastname, String password) {
		try {
			ConnectionData test = new ConnectionData();
			c = test.getConnectionDetails();
			p1 = c.prepareStatement("insert into student(id,firstname,lastname,password) values (?,?,?,?)");
//			PreparedStatement p2 = c.prepareStatement("insert into result (id) values (?)");
			p1.setInt(1, id);
			p1.setString(2, firstname);
			p1.setString(3, lastname);
//			p1.setString(4, username);
//			p1.setString(5, mobile);
			p1.setString(4, password);
			int i = p1.executeUpdate();
//			p2.setInt(1, id);
//			p2.execute();
			System.out.println("Your Registration has been successfully completed ");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void studentRegistry() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your id");
		int id = s.nextInt();
		System.out.println("Enter your FirstName");
		String firstname = s.next();
		System.out.println("Enter your LastName");
		String lastname = s.next();
//		System.out.println("Enter Mobile no");
//		String mobile = s.next();

//		System.out.println("Enter username");
//		String username = s.next();
		System.out.println("Enter your password");
		String password = s.next();

		UserRegistration stu = new UserRegistration();
		stu.insertStudentData(id, firstname, lastname, password);

	}

}
