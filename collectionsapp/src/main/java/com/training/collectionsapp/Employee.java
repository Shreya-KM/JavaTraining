package com.training.collectionsapp;

public class Employee {
 public Employee(int empid, String name, double salary) {
  super();
  this.empid = empid;
  this.name = name;
  this.salary = salary;
 }
 private int empid;
 private String name;
 private double salary;
 public int getEmpid() {
 return empid;
 }
 public void setEmpid(int empid) {
 this.empid = empid;
 }
 public String getName() {
 return name;
 }
 public void setName(String name) {
 this.name = name;
 }
 public double getSalary() {
 return salary;
 }
 public void setSalary(double salary) {
 this.salary = salary;
 }
 @Override
 public String toString() {
 return "Employee [empid=" + empid + ", name=" + name + ", salary=" + salary + "]";
 }
 
 public int compareTo(Employee o) {
  return Double.compare(this.salary, o.salary);
 }
}