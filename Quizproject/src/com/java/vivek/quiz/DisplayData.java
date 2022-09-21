package com.java.vivek.quiz;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DisplayData implements Student {
	Connection c = null;
	PreparedStatement p1 = null;
	
	
	public void displayMethod() {
			try {
				ConnectionData test = new ConnectionData();
				c=test.getConnectionDetails();
				 p1 = c.prepareStatement("SELECT * FROM student;");
				 PreparedStatement p2 = c.prepareStatement("SELECT * FROM result where id = ?");
				ResultSet rs1 = p1.executeQuery();
				while (rs1.next()) {
//					p2.setString(1, rs1.getString(1));
					ResultSet rs2 = p2.executeQuery();
					rs2.next();
					System.out.print("id =" + " "+ rs1.getInt(1));
					System.out.println("\nfirstname :"+rs1.getString(2));
					System.out.println("score ="+ " "+ rs2.getString(1));
				}
				c.close();
				p1.close();
				rs1.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}

	@Override
	public void getMethod()  {
				try {
					
				ConnectionData test = new ConnectionData();
				c=test.getConnectionDetails();
				DataInputStream KB=new DataInputStream(System.in);

				System.out.print("Enter Employee ID:");
				String eid=new Scanner(System.in).next();

				 p1 = c.prepareStatement("Select * from student where id=?");
				 PreparedStatement p2 = c.prepareStatement("SELECT * FROM result where score = ?");

				 p1.setInt(1, Integer.parseInt(eid));
				ResultSet rs = p1.executeQuery();
				ResultSet rs1 = p2.executeQuery();

				if(rs.next()) {
					System.out.print("Student Id: "+rs.getInt(1)+" " + "Score: " +rs1.getString(1));
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
