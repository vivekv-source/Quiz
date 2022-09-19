package com.java.vivek.quiz;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DisplayData implements Student {
	Connection c = null;
	PreparedStatement p1 = null;
	
	@Override
	public void displayMethod() {
			try {
				ConnectionData test = new ConnectionData();
				c=test.getConnectionDetails();
				 p1 = c.prepareStatement("Select StudId,StudName,Score from student");
				ResultSet rs = p1.executeQuery();
				while (rs.next()) {
					System.out.print("ID =" + " "+ rs.getInt("StudId"));
					System.out.println("\nStudent Name :"+rs.getString("StudName"));
					System.out.println("Score ="+ " "+ rs.getString("Score"));
				}
				c.close();
				p1.close();
				rs.close();
				
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
				String eid=KB.readLine();

				 p1 = c.prepareStatement("Select * from student where StudId='"+eid+"'");
				ResultSet rs = p1.executeQuery();

				if(rs.next()) {
					
					System.out.print("Student Id: "+rs.getInt(1)+" " + "Score: " +rs.getString(3));
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
