package com.training.exceptionclass;

public class App {

	public static void show(String name){
		System.out.println(name.toUpperCase());
	}
	
	public static void main(String args[]) {
		try{
			int a = 10;
			int b = 0;
			System.out.println(a / b);
		}catch(ArithmeticException ex){
			System.out.println("Divide By Zero");
			ex.printStackTrace();
		}
		
		try{
			String name = null;
			show(name);
		}catch(NullPointerException ex){
			System.out.println("Null Pointer Exception");
			ex.printStackTrace();
		}
		
		try{
			Object object = 10;
			String name = (String)object;
			System.out.println(name);
		}catch(ClassCastException ex){
			System.out.println("Class Cast Exception");
			ex.printStackTrace();
		}
		
		try{
			int numbers[] = new int[3];
			numbers[3] = 10;
		}catch(ArrayIndexOutOfBoundsException ex){
			System.out.println("Array Index Out Of Bounds Exception");
			ex.printStackTrace();
		}
		
		try{
			Object values[] = new String[3];
			values[0] = 10;
		}catch(ArrayStoreException ex){
			System.out.println("Array Store Exception");
			ex.printStackTrace();
		}
	}
}

