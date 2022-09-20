package com.java.vivek.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Student  {
	
	Connection con=null;
	PreparedStatement ps =null;
	
	public void insertStudentData(int id, String FirstName, String LastName, String username, String password) {
		try {
			ConnectionTest test = new ConnectionTest();
			con=test.getConnection();
			ps= con.prepareStatement("insert into student (id,FirstName,LastName,username,password) values (?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, FirstName);
			ps.setString(3, LastName);
			ps.setString(4, username);
			ps.setString(5, password);
			
			int i = ps.executeUpdate();
			System.out.println("Record is updated "+i);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static Register reg= new Register();
	public static void studentRegistry() {
		Scanner s = new Scanner(System.in);
		for(int i=0; i<1; i++) {
			System.out.println("Enter your id");
			int id = s.nextInt();
			reg.setId(id);
			System.out.println("Enter your FirstName");
			String FirstName = s.next();
			reg.setFirstName(FirstName);
			System.out.println("Enter your LastName");
			String LastName = s.next();
			reg.setLastName(LastName);
			System.out.println("Enter username");
			String username = s.next();
			reg.setUserName(username);
			System.out.println("Enter your password");
			String password = s.next();
			reg.setPassword(password);
			
			Student stu =new Student();
			stu.insertStudentData(id, FirstName, LastName, username, password);
			
			System.out.println(reg.toString());
				
		}
		
		
	}

}
