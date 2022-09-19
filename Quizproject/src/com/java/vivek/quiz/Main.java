package com.java.vivek.quiz;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("======================Welcome to Quiz=====================");
		Thread.sleep(300);
		System.out.println("");
		Mcq a = new Mcq();
		a.getQuestions();
		


	}

}
