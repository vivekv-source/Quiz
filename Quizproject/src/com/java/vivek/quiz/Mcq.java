package com.java.vivek.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.log.Log;

public class Mcq {
	int score = 0;
	static String answer;
	int wrong = 0;
	Connection c = null;
	PreparedStatement p1 = null;

		public void getQuestions(int id) {	
		HashSet<Integer> ls = new HashSet<Integer>();
		boolean checkIfPresent = false ;
		int randomNo = 0;
		Random r = new Random();
		
		try {
			Scanner sc = new Scanner(System.in);
			ConnectionData test = new ConnectionData();
			c=test.getConnectionDetails();
			p1 = c.prepareStatement("Select * from mcq where QID = ?");
			int count = 0;
			

			while ( ls.size()<10) {
				
				while(!checkIfPresent) {
					randomNo = r.nextInt(10)+1;
					checkIfPresent = ls.add(randomNo);				
				}
				checkIfPresent=false;
				p1.setInt(1, randomNo);
				ResultSet rs = p1.executeQuery();
				rs.next();
//				System.out.print(rs.getInt("QID") + ". ");
				System.out.print(++count + ". ");
				System.out.println(rs.getString("Question"));
				Thread.sleep(300);

				System.out.println(" A. " + rs.getString("a"));
				System.out.println(" B. " + rs.getString("b"));
				System.out.println(" C. " + rs.getString("c"));
				System.out.println(" D. " + rs.getString("d"));
				answer =rs.getNString("answer");
				System.out.println("=============================================================================");
				System.out.println("Enter Your Answer: ");
				String ans = sc.nextLine();
			
				boolean b;
				b=answer.equalsIgnoreCase(ans);
				if (b) {
					System.out.println("Your answer is correct ");
					score++;
					System.out.println("=============================================================================");

				} else {
					System.out.println("Your answer is Wrong");
					wrong++;
					System.out.println("=============================================================================");

				}
				
			}
			
			p1 = c.prepareStatement("update quiz.student set score = ? where id = ?");
			p1.setInt(1, score);
			p1.setInt(2, id);
			p1.execute();
			c.close();
			p1.close();
	//		rs.close();
			sc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("================================Result=============================================");
        System.out.println("Total Questions: 10");
        System.out.println("Correct Answered : "+score);
        System.out.println("Wrong Answered : "+wrong);
        
        int marks=score;
        System.out.println("Score : "+marks);
      if(marks>8){
          System.out.println("Class : A");
      }
      else if(marks>=6){
          System.out.println("Class : B");
      }
      else if(marks>=5){
          System.out.println("Class : C");
      }else {
          System.out.println("Class : D " + " Fail ");
      }

      
	}
}