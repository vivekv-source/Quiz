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
			System.out.println("Your Registration is successful");
			System.out.println("===========================================================================");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void studentRegistry() {
		Scanner s = new Scanner(System.in);
		for(int i=0; i<1; i++) {
			System.out.println("Enter your id");
			int id = s.nextInt();

			System.out.println("Enter your FirstName");
			String FirstName = s.next();

			System.out.println("Enter your LastName");
			String LastName = s.next();

			System.out.println("Enter username");
			String username = s.next();

			System.out.println("Enter your password");
			String password = s.next();

			
			Student stu =new Student();
			stu.insertStudentData(id, FirstName, LastName, username, password);
				
		}
			
	}
	public static void main(String[] args) {
		Student.studentRegistry();
	}

}
