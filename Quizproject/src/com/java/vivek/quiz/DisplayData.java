package com.java.vivek.quiz;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DisplayData implements Student {
	Connection c = null;
	PreparedStatement p1 = null;
	
	@Override
	public void displayMethod() {
			try {
				ConnectionData test = new ConnectionData();
				c=test.getConnectionDetails();
				 p1 = c.prepareStatement("SELECT * FROM quiz.student;");
				ResultSet rs = p1.executeQuery();
				while (rs.next()) {
					System.out.print("ID =" + " "+ rs.getInt(1));
					System.out.println("\nStudent Name :"+rs.getString(2));
					System.out.println("Score ="+ " "+ rs.getString(4));
				}
				c.close();
				p1.close();
				rs.close();
				
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

				 p1 = c.prepareStatement("Select * from student where id=?");
				 p1.setInt(1, Integer.parseInt(eid));
				ResultSet rs = p1.executeQuery();

				if(rs.next()) {
					
					System.out.print("Student Id: "+rs.getInt(1)+" " + "Score: " +rs.getString(4));
				}
				else {
					System.out.println("Record Not Found...");

				}
				c.close();
			

			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}

	@Override
	public void getMethod(int id) {
		// TODO Auto-generated method stub
		
	}
	
	}
