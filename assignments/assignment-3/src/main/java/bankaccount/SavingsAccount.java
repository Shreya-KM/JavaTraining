package bankaccount;

public class SavingsAccount extends Account {
	private double interestRate;
	private double minimumBalance;
	
	public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate, double minimumBalance) {
		super(accountNumber, holderName, balance);
		this.interestRate = interestRate;
		this.minimumBalance = minimumBalance;
	}
	
	@Override
	public boolean withdraw(double amount) {
		if(amount <= 0) {
			return false;
		}
		if(getBalance() - amount < minimumBalance) {
			return false;
		}
		setBalance(getBalance() - amount);
		return true;
	}
	
	public double calculateInterest() {
		return getBalance() * interestRate / 100;
	}
	
	@Override
	public void displayAccountDetails() {
		super.displayAccountDetails();
		System.out.println("Interest Rate: " + interestRate + "%");
		System.out.println("Minimum Balance: " + minimumBalance);
	}
}
