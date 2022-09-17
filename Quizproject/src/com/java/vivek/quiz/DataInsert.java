package com.java.vivek.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DataInsert {
	Connection con = null;
	PreparedStatement ps = null;

	public void insertStudentData(int QId,String Question, String Answer) {
		try {
			Mcq test = new Mcq();
			con = test.getConnectionDetails();
			ps = con.prepareStatement("insert into ques(QId,Question,Answer) values(?,?,?)");
			ps.setInt(1, QId);
			ps.setString(2, Question);
			ps.setString(3, Answer);

			int i = ps.executeUpdate();
			System.out.println("Record is inserted successfully.." + i);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void main(String[] args) throws SQLException {
		Scanner sc=null;
		DataInsert user = null;

		try {
			 sc = new Scanner(System.in);
			   user = new DataInsert();

			for (int i = 1; i <= 10; i++) {
				System.out.println("Enetr the Id");
				int qid = sc.nextInt();
				System.out.println("Enetr the Question");
				String question = sc.next();
				System.out.println("Enetr the Answer");
				String answer = sc.next();
				user.insertStudentData(i, question, answer);
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			sc.close();
			user.con.close();
			user.ps.close();

		}

	}

}
