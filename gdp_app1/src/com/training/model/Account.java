package com.training.model;

public class Account {
  private int accountNumber;
  private String name;
  private int Balance;
  private int accountPin;
  private boolean status;
  public int getAccountNumber() {
	return accountNumber;
  }
  public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
  }
  public String getName() {
	return name;
  }
  public void setName(String name) {
	this.name = name;
  }
  public int getBalance() {
	return Balance;
  }
  public void setBalance(int balance) {
	Balance = balance;
  }
  public int getAccountPin() {
	return accountPin;
  }
  public void setAccountPin(int accountPin) {
	this.accountPin = accountPin;
  }
  public boolean isStatus() {
	return status;
  }
  public void setStatus(boolean status) {
	this.status = status;
  }
  
  public boolean getStatus() {
	  return status;
  }
  
  public int withdraw(int amount,int balance) {
	    if (amount > balance) {
	        System.out.println("Insufficient balance.");
	        return balance;
	    }

	    balance = balance - amount;
	    return balance;
	}

	public int deposit(int amount,int balance) {
	    balance = balance + amount;
	    return balance;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", Balance=" + Balance + ", accountPin="
				+ accountPin + ", status=" + status + "]";
	}


}