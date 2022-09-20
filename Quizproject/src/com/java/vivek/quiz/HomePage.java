package com.java.vivek.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HomePage {

	public static Connection con = null;

	public static Scanner sc = null;

	public static Scanner getScanner() {
		return sc = new Scanner(System.in);

	}

	public static Connection getConnection() throws SQLException {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://locallhost:3306/ecommercedb", "root", "Vivek@7263");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) throws SQLException {

		getScanner();

		getConnection();

		System.out.println("Welcome to Quiz");

		System.out.println("======================================================================");

		System.out.println("Please Enter the Choice");

		System.out.println("1.New User Registration");

		System.out.println("2.User Login");

		Integer input = sc.nextInt();

		try {
			switch (input) {
			case 1:
				UserRegistration userreg = new UserRegistration();
				userreg.getUserRegisteration(con, sc);
				break;

			case 2:
				Login login1 = new Login();
				login1.getLogIn(con, sc);

				Mcq m = new Mcq();
				m.getQuestions(0);

				break;
			case 3:
				break;

			default:
				System.out.println("Invalid Input ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
