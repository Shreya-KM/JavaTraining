package bankaccount;

public class CurrentAccount extends Account {
	private double overdraftLimit;
	
	public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
		super(accountNumber, holderName, balance);
		this.overdraftLimit = overdraftLimit;
	}
	
	@Override
	public boolean withdraw(double amount) {
		if(amount <= 0) {
			return false;
		}
		if(amount > getBalance() + overdraftLimit) {
			return false;
		}
		setBalance(getBalance() - amount);
		return true;
	}
	
	@Override
	public void displayAccountDetails() {
		super.displayAccountDetails();
		System.out.println("Overdraft Limit: " + overdraftLimit);
	}
}
