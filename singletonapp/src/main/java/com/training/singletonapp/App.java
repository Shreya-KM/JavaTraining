package com.training.singletonapp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
    	Single s1=Single.getInstance();
    	Single s2=Single.getInstance();
    	
//    	Single s3=new Single();
    	
    	if(s1==s2) {
    		System.out.println("same instances");
    	}
    	else {
    		System.out.println("different instance");
    	}
    	
    }
}
