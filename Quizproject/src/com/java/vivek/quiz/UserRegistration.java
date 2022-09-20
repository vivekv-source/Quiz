package com.java.vivek.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserRegistration {

	public void getUserRegisteration(Connection con,Scanner sc) {	
			
		System.out.println("Welcome to Quiz");
		
		System.out.println("===================================================");
		try {
		
					System.out.println("Please Fill the Registeration Deatail");
					
		
					System.out.println("Please Enter the First Name:=");
		
						String fname=sc.next();
		
					
					System.out.println("please Enter the Last Name:=");
					
						String lname=sc.next();
		
		
					System.out.println("please Enter the mobile number:=");
		
						String mobilenum=sc.next();
		
		
					System.out.println("Please Enter the Address:= ");
		
						String address=sc.next();
		
					System.out.println("please Enter the username:");
		
					String username=sc.next();
		
					System.out.println("Please Enter the Password");
		
					String password=sc.next();
		
					UserInfo user1=new UserInfo(fname,lname,mobilenum,address,username,password);
					
					
					PreparedStatement preparedStatement1 =con.prepareStatement("select *  from user");
					
					ResultSet rs=preparedStatement1.executeQuery();
					
					
					
					
					
		
			PreparedStatement preparedStatement2 =con.prepareStatement("insert ignore into user"
					+ "(firstname ,lastname,mobilenumber,address,username,password)"
					+ " values(?,?,?,?,?,?)");
			
					
			preparedStatement2.setString(1,user1.getFirstName());
			
			preparedStatement2.setString(2,user1.getLastName());
			preparedStatement2.setString(3,user1.getMobileNumber());
			preparedStatement2.setString(4,user1.getAddress());
			
				boolean flag=false;
				while(rs.next())
				{
					if(user1.getUserName().equals(rs.getString(6)) && user1.getPassword().equals(rs.getString(7)))
				
					{
						
						System.out.println("User Already Registered  Please Login");
						
						
						flag=true;
					}
				
					
				}
			
				if(flag!=true)
				
				{
					preparedStatement2.setString(5,user1.getUserName());
					preparedStatement2.setString(6,user1.getPassword());
					
					 preparedStatement2.executeUpdate();

						System.out.println("You are Registered Successfully");
				
				
				}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			
	}
	

	
}



