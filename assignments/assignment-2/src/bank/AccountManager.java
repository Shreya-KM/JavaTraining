package bank;

public class AccountManager {
	Account accounts[] = new Account[5];
	
	public boolean addAccount(Account account) {
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i] == null) {
				accounts[i] = account;
				return true;
			}
		}
		return false;
	}
	
	public boolean withdrawTransaction(int accountNumber, int pin, int amount) {
		Account account = findAccount(accountNumber, pin);
		if(account == null) {
			return false;
		}
		return account.withdraw(amount);
	}
	
	public boolean depositTransaction(int accountNumber, int pin, int amount) {
		Account account = findAccount(accountNumber, pin);
		if(account == null) {
			return false;
		}
		return account.deposit(amount);
	}
	
	public int showBalance(int accountNumber, int pin) {
		Account account = findAccount(accountNumber, pin);
		if(account == null) {
			return -1;
		}
		return account.getBalance();
	}
	
	public Account findAccount(int accountNumber, int pin) {
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i] != null && accounts[i].getAccountNumber() == accountNumber && accounts[i].getAccountPin() == pin) {
				return accounts[i];
			}
		}
		return null;
	}
}
