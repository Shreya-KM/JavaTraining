package bankaccount;

public abstract class Account {
	private String accountNumber;
	private String holderName;
	private double balance;
	
	public Account(String accountNumber, String holderName, double balance) {
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		if(balance >= 0) {
			this.balance = balance;
		}
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getHolderName() {
		return holderName;
	}
	public double getBalance() {
		return balance;
	}
	
	protected void setBalance(double balance) {
		this.balance = balance;
	}
	
	public boolean deposit(double amount) {
		if(amount <= 0) {
			return false;
		}
		setBalance(getBalance() + amount);
		return true;
	}
	
	public abstract boolean withdraw(double amount);
	
	public void displayAccountDetails() {
		System.out.println("Type: " + getClass().getSimpleName());
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Holder Name: " + holderName);
		System.out.println("Balance: " + balance);
	}
}
