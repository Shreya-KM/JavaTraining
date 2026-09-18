package bankaccount;

public class FixedDepositAccount extends Account {
	private double interestRate;
	private int tenureInYears;
	
	public FixedDepositAccount(String accountNumber, String holderName, double balance, double interestRate, int tenureInYears) {
		super(accountNumber, holderName, balance);
		this.interestRate = interestRate;
		this.tenureInYears = tenureInYears;
	}
	
	@Override
	public boolean withdraw(double amount) {
		return false;
	}
	
	public double calculateMaturityAmount() {
		double interest = getBalance() * interestRate * tenureInYears / 100;
		return getBalance() + interest;
	}
	
	@Override
	public void displayAccountDetails() {
		super.displayAccountDetails();
		System.out.println("Interest Rate: " + interestRate + "%");
		System.out.println("Tenure: " + tenureInYears + " years");
	}
}
