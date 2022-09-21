package com.java.vivek.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Login {

	PreparedStatement ps = null;
	Connection connection = null;
	ResultSet rs = null;
	String no;
	int id;
	String password;
	int i;
	static String answer;
	int score = 0;

	public void getLoginDetails() {

		Mcq mcq = new Mcq();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your User Id");
		boolean a;
		no = sc.next();
		System.out.println("Enter your Password");
		password = sc.next();
		try {
			ConnectionData test = new ConnectionData();
			connection = test.getConnectionDetails();
			ps = connection.prepareStatement("select password from student where id =? ");
			ps.setString(1, no);
			rs = ps.executeQuery();
			
			String existigpassword = (rs.next()) ? rs.getString("password") : "";
			if (password.equals(existigpassword)) {
				mcq.getQuestions(Integer.parseInt(no));
			} else {

				System.out.println("Incorrect Userid or Password");
				System.exit(0);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getUserId() {
		return id;		
	}

	public void display() {
		String sql1 = "select * from student";
		try {
			ConnectionData test = new ConnectionData();
			connection = test.getConnectionDetails();
			ps = connection.prepareStatement(sql1);
			rs = ps.executeQuery();
			rs.next();
			id = rs.getInt("id");

			ps.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void getQuestions() {
		int wrong = 0;

		HashSet<Integer> ls = new HashSet<Integer>();
		boolean checkIfPresent = false;
		int randomNo = 0;
		Random r = new Random();
		Login login = new Login();

		try {
			Scanner sc = new Scanner(System.in);
			ConnectionData test = new ConnectionData();
			connection = test.getConnectionDetails();
			ps = connection.prepareStatement("Select * from mcq where QID = ?");
			int count = 0;

			while (ls.size() < 10) {

				while (!checkIfPresent) {
					randomNo = r.nextInt(10) + 1;
					checkIfPresent = ls.add(randomNo);
				}
				checkIfPresent = false;
				ps.setInt(1, randomNo);
				ResultSet rs = ps.executeQuery();
				rs.next();
//					System.out.print(rs.getInt("QID") + ". ");
				System.out.print(++count + ". ");
				System.out.println(rs.getString("Question"));
				Thread.sleep(300);

				System.out.println(" A. " + rs.getString("a"));
				System.out.println(" B. " + rs.getString("b"));
				System.out.println(" C. " + rs.getString("c"));
				System.out.println(" D. " + rs.getString("d"));
				answer = rs.getNString("answer");
				System.out.println("=============================================================================");
				System.out.println("Enter Your Answer: ");
				String ans = sc.next();

				boolean b;
				b = answer.equalsIgnoreCase(ans);
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
			System.out.println();
			System.out.println("================================Result=============================================");
			System.out.println("Total Questions: 10");
			System.out.println("Correct Answered : " + score);
			System.out.println("Wrong Answered : " + wrong);

			int marks = score;
			System.out.println("Score : " + marks);
			if (marks > 8) {
				System.out.println("Class : A");
			} else if (marks >= 6) {
				System.out.println("Class : B");
			} else if (marks >= 5) {
				System.out.println("Class : C");
			} else {
				System.out.println("Class : D " + "\n Fail ");
			}

			ps.execute();
			connection.close();
			ps.close();
//			rs.close();
			sc.close();
//			Quiz q= new Quiz();
//			q.displayMethod();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.exit(0);
	}
}
