package com.oop_pub;

import java.util.Random;

public class PasswordMakerSingleton {
	private static PasswordMakerSingleton instance;
	private static int counter;
	String name;
	final int MAGIC_NUMBER = 15;
	final String MAGIC_STRING = new RandomStringGenerator(20, "abcdefghijklmnopqrstuvwxyz").next();
	
	static {
		instance = new PasswordMakerSingleton("Gigel");
		counter = 0;
	}
	
	private PasswordMakerSingleton(String name){
		this.name = name;
	}
	
	public static PasswordMakerSingleton getInstance() {
		PasswordMakerSingleton.counter++;
		return instance;
	}
	
	public String getPassword(){
		String randomstring = new RandomStringGenerator(10, "abcdefghijklmnopqrstuvwxyz").next();
		Random random = new Random();
		Integer random_int = random.nextInt(100);
		Integer length = name.length();
		return randomstring + length.toString() + random_int.toString();
	}
	
	public int getCounter() {
		return counter;
	}

	public static void main(String[] args) {
		PasswordMakerSingleton passmaker = PasswordMakerSingleton.getInstance();
		PasswordMakerSingleton passmaker1 = PasswordMakerSingleton.getInstance();
		PasswordMakerSingleton passmaker2 = PasswordMakerSingleton.getInstance();
		System.out.println(passmaker.getPassword());
		Integer counter = passmaker.getCounter();
		System.out.println(counter);
		// All good
		// Raspuns tema de gandire: fiecare thread va avea propriul sau Singleton
		// asa ca practic nu va functiona ca un Singleton raportat la intreg sistemul
	}
}
