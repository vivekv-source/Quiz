package com.java.vivek.quiz;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Quiz {
	Connection c = null;
	PreparedStatement p1 = null;

	public void displayMethod() {
		try {
			ConnectionData test = new ConnectionData();
			c=test.getConnectionDetails();
			 p1 = c.prepareStatement("SELECT s.id,s.firstname,a.score FROM student AS s LEFT JOIN result AS a on a.score");
//			 PreparedStatement p2 = c.prepareStatement("SELECT * FROM result where score = ?");
			ResultSet rs1 = p1.executeQuery();
			while (rs1.next()) {
//				p2.setString(1, rs1.getString(1));
//				ResultSet rs2 = p2.executeQuery();
//				rs2.next();
				System.out.print("id =" + " "+ rs1.getInt(1));
				System.out.println("\nfirstname :"+rs1.getString(2));
				System.out.println("score ="+ " "+ rs1.getInt(3));
			}
			c.close();
			p1.close();
			rs1.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

public void getMethod()  {
			try {
				
			ConnectionData test = new ConnectionData();
			c=test.getConnectionDetails();
			DataInputStream KB=new DataInputStream(System.in);

			System.out.print("Enter Employee ID:");
			String eid=new Scanner(System.in).next();

			 p1 = c.prepareStatement("SELECT s.id,s.firstname,a.score FROM student AS s LEFT JOIN result AS a on a.score");
//			 PreparedStatement p2 = c.prepareStatement("SELECT * FROM result where score = ?");

//			 p1.setInt(1, Integer.parseInt(eid));
			ResultSet rs = p1.executeQuery();
//			ResultSet rs1 = p2.executeQuery();

			if(rs.next()) {
//				System.out.print("Student Id: "+rs.getInt(1)+"||"+"Student Name: "+rs.getString(2)+"||" + "Score: " +rs.getInt(3));
				System.out.print("id =" + " "+ rs.getInt(1));
				System.out.println("\nfirstname :"+rs.getString(2));
				System.out.println("score ="+ " "+ rs.getInt(3));

			}
			else {
				System.out.println("Record Not Found...");

			}
			c.close();
		

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}



}
