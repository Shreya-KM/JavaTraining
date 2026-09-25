package com.training.stackapp;

public class App {
	public static void main(String args[]) {
		try{
		Stack stack=new Stack(5);
		stack.push(10);
		stack.push(20);
		stack.push(30);

		System.out.println(stack.pop());
		}
		catch(StackException e){
			e.printStackTrace();
		}
	}
}
