package com.training.model;

public class AccountMain {

	Account a = new Account(); 
	a.setAccountNumber(123);
	a.setAccountPin(2345);
	a.setBalance(4000);
	a.setName("shreya");
	a.setStatus(true);
	 
	 System.out.println(a.getName());
	 System.out.println(a.getAccountNumber());
	 System.out.println(a.getAccountPin());
	 System.out.println(a.getBalance());
	 System.out.println(a.getStatus());
	 System.out.println("Initial Balance: " + a.getBalance());

	 int depositBalance = a.deposit(500,a.getBalance());
	 System.out.println("Balance after deposit: " + depositBalance);
	 a.setBalance(depositBalance);

	 int withdrawBalance = a.withdraw(1000,a.getBalance());
	 System.out.println("Balance after withdrawal: " + withdrawBalance);
	 
	 System.out.println(a);
	}
}