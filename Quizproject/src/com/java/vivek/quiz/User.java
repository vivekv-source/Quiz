package com.java.vivek.quiz;

import java.util.Scanner;

public class User {
	private int uid;
	private String name;
	private String password;
	private Scanner sc = new Scanner(System.in);
	public User(int uid, String name, String password) {
		this.uid = uid;
		this.name = name;
		this.password = password;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}