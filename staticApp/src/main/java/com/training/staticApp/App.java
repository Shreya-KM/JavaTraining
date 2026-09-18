package com.training.staticApp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	
    	System.out.println(Employee.getCount());
    	Employee e1 =  new Employee(1,"shreya","Proj Manager");
    	Employee e2 =  new Employee(1,"shreya1","Proj Manager");
    	
    	System.out.println(e1);
    	System.out.println(e2);
    	
    	System.out.println(Employee.getCount());
    	
    	
    }
}
