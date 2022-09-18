package com.java.vivek.quiz;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionData {
		Connection connection=null;
		public Connection getConnectionDetails() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Vivek@7263");			
			
							} catch (Exception e) {
					e.printStackTrace();
				}
			return connection;
				}

		}
			
