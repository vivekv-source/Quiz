package com.java.vivek.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Score {
	Connection con=null;
	PreparedStatement ps =null;
	
	public void insertScoreData(int id, int TotalScore, int ReceivedScore) {
		try {
			ConnectionTest test = new ConnectionTest();
			con=test.getConnection();
			ps= con.prepareStatement("insert into score (id,TotalScore, ReceivedScore) values (?,?,?)");
			ps.setInt(1, TotalScore);
			ps.setInt(2, TotalScore);
			ps.setInt(3, ReceivedScore);
			
			int i1 = ps.executeUpdate();
			System.out.println("Record is updated "+i1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
Score sco = new Score();
		
		
	}
	
				
		
		
		
	}



	


