package com.oop_pub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyImmutableArray {
	static ArrayList<Integer> immutableArray;
	
	public MyImmutableArray(ArrayList<Integer> array) {
		immutableArray = new ArrayList<Integer>();
		for(Integer number : array) {
			immutableArray.add(number);
		}
	}
	
	public List<Integer> getArray() {
		return Collections.unmodifiableList(immutableArray);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(15);
		array.add(20);
		array.add(25);
		MyImmutableArray myimmutablearray = new MyImmutableArray(array);
		List<Integer> immutablearray = myimmutablearray.getArray();
		
		try {
			immutablearray.add(40);
		}
		catch (Exception e) {
			System.out.println("Nu poti adauga intr-un immutablearray!");
		}
		
		try {
			immutablearray.remove(0);
		}
		catch (Exception e) {
			System.out.println("Nu poti sterge dintr-un immutablearray!");
		}
		
		System.out.println(immutablearray);
		// All good
	}
}
