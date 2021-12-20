package com.oop_pub;
import java.util.Random;

public class PasswordMaker {
	String name;
	final int MAGIC_NUMBER = 15;
	final String MAGIC_STRING = new RandomStringGenerator(20, "abcdefghijklmnopqrstuvwxyz").next();
	
	public PasswordMaker(String name){
		this.name = name;
	}
	
	public String getPassword(){
		String randomstring = new RandomStringGenerator(10, "abcdefghijklmnopqrstuvwxyz").next();
		Random random = new Random();
		Integer random_int = random.nextInt(100);
		Integer length = name.length();
		return randomstring + length.toString() + random_int.toString();
	}

	public static void main(String[] args) {
		PasswordMaker passmaker = new PasswordMaker("Gigel");
		System.out.println(passmaker.getPassword());
	}
}
