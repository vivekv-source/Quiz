package com.java.vivek.quiz;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Answer {
	int score=0;
	int wrong=0;
	
	public void getQuestions() {
		int score=0;
		Scanner sc =new Scanner(System.in);
		
		Question q1 = new Question("Who is known as father of Java Programming Language?", "(a)James Gosling", "(b)M. P Java", "(c)Charel Babbage", "(d)Blais Pascal");
		Question q2 = new Question("Number of primitive data types in Java are?", "(a) 6", "(b) 7", "(c)8", "(d) 9");
		Question q3 = new Question("Which provides runtime environment for java byte code to be executed?", "(a)JDK", "(b)JRE", "(c)JVM", "(d)JAVAC");
		Question q4 = new Question("Which one is a template for creating different objects ?", "(a)Array", "(b)Class", "(c)Interface", "(d)Method");
		Question q5 = new Question("When is the object created with new keyword?", "(a)At runtime", "(b)At Compiletime", "(c)Depends upon the code", "(d)None");
		Question q6 = new Question("In which of the following is toString() method defined?", "(a) java.lang.Object", "(b) java.lang.String", "(c)java.util", "(d) None");
		Question q7 = new Question("compareTo() returns?", "(a) True", "(b) False", "(c) int value", "(d) None");
		Question q8 = new Question("Which of the following are not the methods of the Thread class?", "(a) yield()", "(b) sleep(long msec)", "(c)go()", "(d) Stop()");
		Question q9 = new Question("What is the full form of JVM ?", "(a) Java Verylarge Machine", "(b) Java Verified Machine", "(c)Java Verysmall Machine", "(d) Java Virtual Machine");
		Question q10 = new Question("Which of the following are not Java modifiers?", "(a) public", "(b) private", "(c)friendly", "(d) transient");

		Map<Question,Character> hmap = new LinkedHashMap<>();
		hmap.put(q1, 'a');
		hmap.put(q2, 'c');
		hmap.put(q3, 'c');
		hmap.put(q4, 'b');
		hmap.put(q5, 'a');
		hmap.put(q6, 'a');
		hmap.put(q7, 'c');
		hmap.put(q8, 'c');
		hmap.put(q9, 'd');
		hmap.put(q10, 'c');
		
		for(Map.Entry<Question, Character> map: hmap.entrySet()) {
			System.out.println(map.getKey().getQuestio());
			System.out.println(map.getKey().getOption1());
			System.out.println(map.getKey().getOption2());
			System.out.println(map.getKey().getOption3());
			System.out.println(map.getKey().getOption4());
			
			
			System.out.println("Enter your answer");
			Character ans = sc.next().charAt(0);
			
			int cans = Character.compare(ans,map.getValue());
			if(cans==0) {
				System.out.println("Correct");
				score++;
			}
			else {
				System.out.println("Wrong");
				wrong++;
			}
		}
		System.out.println("Your Score is "+score+"wrong answer are"+wrong);
 	
	}
	public static void main(String[] args) {
		Answer a= new Answer();
		a.getQuestions();
	}

}
