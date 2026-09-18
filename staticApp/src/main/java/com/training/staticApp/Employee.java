package com.training.staticApp;

public class Employee {
   public Employee(int empID, String name, String designation) {
	  super();
	  this.EmpID = empID;
	  this.name = name;
	  this.Designation = designation;
	  count++;
	 }
   private int EmpID;
   private String name;
   private String Designation;
   
   private static int count;
   
   public static int getCount() {
	return count;
}
   public static void setCount(int count) {
	Employee.count = count;
   }
   public Employee() {
	   count++;
   }
   @Override
   public String toString() {
	   return "Employee [EmpID=" + EmpID + ", name=" + name + ", Designation=" + Designation + "]";
   }
   
} 