package bank;

public class Account {
	private int accountNumber;
	private String name;
	private int Balance;
	private int accountPin;
	private boolean status;
	
	public Account() {
	}
	
	public Account(int accountNumber, String name, int accountPin) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.accountPin = accountPin;
		this.status = true;
	}
	
	public Account(int accountNumber, String name, int balance, int accountPin, boolean status) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.accountPin = accountPin;
		this.status = status;
		setBalance(balance);
	}
	
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
		if(balance >= 0) {
			Balance = balance;
		}
	}
	public int getAccountPin() {
		return accountPin;
	}
	public void setAccountPin(int accountPin) {
		this.accountPin = accountPin;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public boolean withdraw(int amount) {
		if(amount <= 0 || amount > getBalance() || !getStatus()) {
			return false;
		}
		setBalance(getBalance() - amount);
		return true;
	}
	
	public boolean deposit(int amount) {
		if(amount <= 0 || !getStatus()) {
			return false;
		}
		setBalance(getBalance() + amount);
		return true;
	}
}
