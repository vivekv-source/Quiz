package com.java.vivek.quiz;

import java.io.DataInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DisplayData extends ConnectionData  {
	Connection c = null;
	PreparedStatement p1 = null;
//	int userId;
//	public DisplayData(int userId) {
//		this.userId = userId;
//	}
	
	
	public void displayMethod(int userId) {
			try {
           ConnectionData test = new ConnectionData();
				c=test.getConnectionDetails();
				PreparedStatement p1 = c.prepareStatement("SELECT r.score,r.id,s.firstname,s.lastname FROM result r join student s on (r.id=s.id) where r.id=?");
				p1.setInt(1, userId);
				ResultSet rs1 = p1.executeQuery();
				while (rs1.next()) {
					System.out.print("id =" + " "+ rs1.getInt("id"));
					System.out.print("\nfirstname =" + " "+ rs1.getString("firstname"));
					System.out.println("\nlastname :"+rs1.getString("lastname"));
					System.out.println("score ="+ " "+ rs1.getInt("score"));
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
					PreparedStatement p1 = c.prepareStatement("SELECT r.score,r.id,s.firstname,s.lastname FROM result r join student s on (r.id=s.id)");
					ResultSet rs1 = p1.executeQuery();
					while (rs1.next()) {
						System.out.print("id =" + " "+ rs1.getInt("id"));
						System.out.print("\nfirstname =" + " "+ rs1.getString("firstname"));
						System.out.println("\nlastname :"+rs1.getString("lastname"));
						System.out.println("score ="+ " "+ rs1.getInt("score"));
					}
					c.close();
					p1.close();
					rs1.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
			
		}

	}
