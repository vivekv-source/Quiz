package com.java.vivek.quiz;

import java.util.Scanner;

public class Question {
	
	String ques;
	String answer;
	
	public Question(String ques, String answer) {
		this.ques= ques;
		this.answer= answer;
		
	}


	public static  void quizQuestions(){
	
	    String q1 = "Who is known as father of Java Programming Language?\n" 
	          + "(a)James Gosling\n(b)M. P Java\n(c)Charel Babbage\n(d)Blais Pascal\n"; 
	 
	    String q2 = "Number of primitive data types in Java are?\n" 
	          + "(a)6\n(b)7\n(c)8\n(d)9\n"; 
	 
	    String q3 = "Which provides runtime environment for java byte code to be executed?\n" 
	          + "(a)JDK\n(b)JRE\n(c)JVM\n(d)JAVAC\n"; 
	 
	    String q4 = "Which one is a template for creating different objects ?\n" 
	          + "(a)Array\n(b)Class\n(c)Interface\n(d)Method\n"; 
	 
	    String q5 = "When is the object created with new keyword?\n" 
	          + "(a)At runtime\n(b)At Compiletime\n(c)Depends upon the code\n(d)none\n"; 
	 
	    String q6 = " In which of the following is toString() method defined?\n" 
	          + "(a)java.lang.Object\n(b)java.lang.String\n(c)java.util\n(d)None\n"; 
	 
	    String q7 = "compareTo() returns?\n" 
	          + "(a)true\n(b)false\n(c)int value\n(d)None\n"; 
	 
	    String q8 = "Which of the following are not the methods of the Thread class?\n" 
	          + "(a)yield()\n(b)sleep(long msec)\n(c)go()\n(d)stop()\n"; 
	 
	    String q9 = "What is the full form of JVM ?\n" 
	          + "(a)Java Very Large Machine\n(b)Java Verified Machine\n(c)Java Very Small Machine\n(d)Java Virtual Machine\n"; 
	 
	    String q10 = "Which of the following are not Java modifiers?\n" 
	          + "(a)public\n(b)private\n(c)friendly\n(d)transient\n"; 
	
	 
	    Question [] questions = { 
	            new Question(q1, "a\n"+"Answer = James Gosling"), 
	            new Question(q2, "a"), 
	            new Question(q3, "b"), 
	            new Question(q4, "c"), 
	            new Question(q5, "d"), 
	            new Question(q6, "a"), 
	            new Question(q7, "a"), 
	            new Question(q8, "c"), 
	            new Question(q9, "a"), 
	            new Question(q10, "c") 
	    }; 
	    takeTest(questions); 
	 
	 
	} 
	 
	public static void takeTest(Question [] questions){ 
	    int score = 0; 
	    Scanner keyboardInput = new Scanner(System.in); 
	 
	 
	    for(int i = 0; i < questions.length; i++) { 
	        System.out.println(questions[i].ques); 
	        String answer = keyboardInput.nextLine(); 
	        if(answer.equals(questions[i].answer)) { 
	            score++; 
	        } 
	    } 
	    System.out.println("You got " + score + "/" + questions.length); 
	}
	
	public static void main(String[] args) {
		quizQuestions();
	}
	
	
	}
	


