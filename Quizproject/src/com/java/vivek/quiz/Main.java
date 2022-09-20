package com.java.vivek.quiz;

public class Main {

	public static void main(String[] args) {
		
System.out.println("==============================================Welcome to Quiz=============================================");
		Mcq m= new Mcq();
		m.getQuestions(0);
//		
		System.out.println("==========================================================================================");

		DisplayData data= new DisplayData();
		data.displayMethod();
		data.getMethod();
				
		
	}

}
