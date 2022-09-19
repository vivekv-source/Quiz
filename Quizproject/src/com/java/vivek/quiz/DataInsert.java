package com.java.vivek.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataInsert {
	Connection con = null;
	PreparedStatement ps = null;

	public void insertStudentData() {
		try {
			ConnectionData test = new ConnectionData();
			con=test.getConnectionDetails();
			ps = con.prepareStatement("insert into mcq(QID,a,b,c,d,answer)values(?,?,?,?,?,?,?)");
			ps.setInt(1, 1);
			ps.setString(2, "Who is known as father of Java Programming Language?");
			ps.setString(3, "James Gosling ");
			ps.setString(4, "M. P Java");
			ps.setString(5, "Charel Babbage");
			ps.setString(6, "Blais Pascal");
			ps.setString(7, "A");
//--------------------------------------------------------------------------------------------------------------			
//			ps.setInt(1, 2);
//			ps.setString(2, "Number of primitive data types in Java are?");
//			ps.setString(3, "6");
//			ps.setString(4, "7");
//			ps.setString(5, "8");
//			ps.setString(6, "9");
//			ps.setString(7, "C");
//--------------------------------------------------------------------------------------------------------------			
//			ps.setInt(1, 3);
//			ps.setString(2, "Which provides runtime environment for java byte code to be executed?");
//			ps.setString(3, "JDK");
//			ps.setString(4, "JVM");
//			ps.setString(5, "JRE");
//			ps.setString(6, "JAVAC");
//			ps.setString(7, "B");
//
			//--------------------------------------------------------------------------------------------------------------			
//			ps.setInt(1, 4);
//			ps.setString(2, "Which one is a template for creating different objects ?");
//			ps.setString(3, "An Array");
//			ps.setString(4, "A class");
//			ps.setString(5, "Interface");
//			ps.setString(6, "Method");
//			ps.setString(7, "B");

			
//			//--------------------------------------------------------------------------------------------------------------			
//			ps.setInt(1, 5);
//			ps.setString(2, "When is the object created with new keyword?");
//			ps.setString(3, "At runtime");
//			ps.setString(4, "At compile time");
//			ps.setString(5, "Depends on the code");
//			ps.setString(6, "None");
//			ps.setString(7, "A");

//			//--------------------------------------------------------------------------------------------------------------			
//			ps.setInt(1, 6);
//			ps.setString(2, "In which of the following is toString() method defined?");
//			ps.setString(3, "java.lang.Object");
//			ps.setString(4, "java.lang.String.");
//			ps.setString(5, "java.lang.util.");
//			ps.setString(6, "None");
//			ps.setString(7, "A");
//
//			//--------------------------------------------------------------------------------------------------------------			
//			ps.setInt(1, 7);
//			ps.setString(2, "compareTo() returns");
//			ps.setString(3, "True");
//			ps.setString(4, "False");
//			ps.setString(5, "An int value");
//			ps.setString(6, "None");
//			ps.setString(7, "C");
//
//			//--------------------------------------------------------------------------------------------------------------			
//			ps.setInt(1, 8);
//			ps.setString(2, "Which of the following are not the methods of the Thread class?");
//			ps.setString(3, "yield()");
//			ps.setString(4, "sleep(long msec)");
//			ps.setString(5, "go()");
//			ps.setString(6, "stop()");
//			ps.setString(7, "C");
//
			//--------------------------------------------------------------------------------------------------------------			
//			ps.setInt(1, 9);
//			ps.setString(2, "What is the full form of JVM ?");
//			ps.setString(3, "Java Very Large Machine");
//			ps.setString(4, "Java Verified Machine");
//			ps.setString(5, "Java Very Small Machine");
//			ps.setString(6, "Java Virtual Machine");
//			ps.setString(7, "D");
//
////			//--------------------------------------------------------------------------------------------------------------			
//			ps.setInt(1, 10);
//			ps.setString(2, "Which of the following are not Java modifiers?");
//			ps.setString(3, "public");
//			ps.setString(4, "private");
//			ps.setString(5, "friendly");
//			ps.setString(6, "transient");
//			ps.setString(7, "C");


//--------------------------------------------------------------------------------------------------------------			

			int i = ps.executeUpdate();
			System.out.println("Record is inserted successfully.." + i);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
