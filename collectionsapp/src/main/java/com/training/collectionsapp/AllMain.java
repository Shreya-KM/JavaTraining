package com.training.collectionsapp;

import java.util.ArrayList;
import java.util.List;

public class AllMain {
	public static void main(String args[]) {
		List<Object> values = new ArrayList<Object>();
		values.add("Shreya");
		values.add(10);
		values.add(25.5);
		values.add(true);
		values.add('A');
		
		System.out.println(values);
		
		for(Object value:values) {
			System.out.println(value);
		}
	}
}
