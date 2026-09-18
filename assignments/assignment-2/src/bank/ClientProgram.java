package bank;

import java.util.Arrays;

public class ClientProgram {
	public static void main(String[] args) {
		AccountManager manager = new AccountManager();
		Account account1 = new Account(101, "shreya", 5000, 1234, true);
		Account account2 = new Account(102, "ravi", 2500, 5678, true);
		manager.addAccount(account1);
		manager.addAccount(account2);
		
		manager.depositTransaction(101, 1234, 1000);
		manager.withdrawTransaction(101, 1234, 2000);
		System.out.println("Balance: " + manager.showBalance(101, 1234));
		
		int numbers[] = {8,2,5,1,9};
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
	}
}
