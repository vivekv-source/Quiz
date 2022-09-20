package com.java.vivek.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Login {
	

	public static String username =null;
	public static String password =null;
	
	public void getLogIn(Connection con,Scanner sc) 
	
	{
		PreparedStatement preparedStatement =null;
		ResultSet resultSet =null;
		
		Map <String ,String> map = new LinkedHashMap<String,String>();
	
		try
		{
			preparedStatement=con.prepareStatement("select * from student");
			resultSet =preparedStatement.executeQuery();
			boolean flag=false;
			while(resultSet.next())
			{
				map.put(resultSet.getString(6), resultSet.getString(7));
			
				System.out.println("Enter username and password which you have entered during registration time 😊 😊 😊");	
				System.out.println();
				System.out.println("Enter the Username : ");
				username=sc.next();
				System.out.println("Enter the Password : ");
				password =sc.next();
				System.out.println("------------------------------------------------------------------------------------------------");
		
				Set <String > set = map.keySet();
				
				
				if(set.contains(username)) 
				{
					if(password.equals(map.get(username)))
					{
						System.out.println("Log In Successfully 😀 😀 😀    /n "+ "😊  WELCOME 😊");
						System.out.println("-------------------------------------------------------------------------------------------------");
						flag=true;
						break;
					}
					
				}
		}
			if(flag!=true)
			{
				System.out.println("Sorry 😢😢 , You entered Invalid username OR password please check once and try again 🙏🙏");
				System.out.println("----------------------------------------------------------------------------------------------");
				getLogIn(con, sc);
			}
			
			
	}catch(Exception e) {
		e.printStackTrace();
	}
	}	
	
}