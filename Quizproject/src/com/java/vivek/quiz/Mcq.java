package com.java.vivek.quiz;

import java.sql.Connection;
import java.sql.DriverManager;

public class Mcq {
		Connection connection=null;
		public Connection getConnectionDetails() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","Vivek@7263");			
			
			//	PreparedStatement stmt= con.prepareStatement("insert into ques(QId,Question,Answer)values(?,?,?)");
							} catch (Exception e) {
					e.printStackTrace();
				}
			return connection;
				}

		}
			
