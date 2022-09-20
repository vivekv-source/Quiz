package com.java.vivek.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Answer {
	int x;
	int mark;
	int wrong;
	Connection c = null;
	PreparedStatement p1 = null;
	

	public void getQuestions() {
	try {
		Scanner sc =new Scanner(System.in);
		ConnectionTest test = new ConnectionTest();
		c=test.getConnection();
		p1=c.prepareStatement("select * from mcq ");
		ResultSet res = p1.executeQuery();
		while(res.next()) {
			System.out.print(res.getInt("Q_id")+". ");
			System.out.println(res.getString("Question"));
			System.out.println(res.getString("a"));
			System.out.println(res.getString("b"));
			System.out.println(res.getString("c"));
			System.out.println(res.getString("d"));
			
			
			System.out.println("Enter your answer");
			String ans = sc.nextLine();
			
			boolean result = ans.equals(res.getString("CorrectOption"));
			if(result) {
				System.out.println("Your answer is correct ");
				mark++;
			}
			else {
				System.out.println("Wrong");
				wrong++;
			}
		}
		x=mark;
		System.out.println("Please enter id to proceed");
		int id=sc.nextInt();
		int ReceivedScore=x;
		int TotalScore =10;
		Score s = new Score();
		s.insertScoreData(id, TotalScore, ReceivedScore);
		
		
	}
	
	catch (Exception e) {
		e.printStackTrace();
	}
	}
	public static void main(String[] args) {
		
		Answer as= new Answer();
		as.getQuestions();
}
	}
