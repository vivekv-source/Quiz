package com.java.vivek.quiz;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
	
	Connection connection =null;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","Shubham@8378");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
