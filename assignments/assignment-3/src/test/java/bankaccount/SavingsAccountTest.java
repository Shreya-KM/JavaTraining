package bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {
    private SavingsAccount account;

    @BeforeEach
    void setUp() {
        account = new SavingsAccount("S101", "Ravi", 10000, 6.5, 2000);
    }

    @Test
    void accountCreationShouldSetDetails() {
        assertEquals("S101", account.getAccountNumber());
        assertEquals("Ravi", account.getHolderName());
        assertEquals(10000, account.getBalance(), 0.001);
    }

    @Test
    void validDepositShouldIncreaseBalance() {
        assertTrue(account.deposit(2000));
        assertEquals(12000, account.getBalance(), 0.001);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 0, -1000 })
    void invalidDepositShouldNotChangeBalance(double amount) {
        assertFalse(account.deposit(amount));
        assertEquals(10000, account.getBalance(), 0.001);
    }

    @Test
    void validWithdrawalShouldReduceBalance() {
        assertTrue(account.withdraw(5000));
        assertEquals(5000, account.getBalance(), 0.001);
    }

    @Test
    void withdrawalToMinimumBalanceShouldSucceed() {
        assertTrue(account.withdraw(8000));
        assertEquals(2000, account.getBalance(), 0.001);
    }

    @Test
    void withdrawalBelowMinimumBalanceShouldFail() {
        assertFalse(account.withdraw(8001));
        assertEquals(10000, account.getBalance(), 0.001);
    }

    @Test
    void interestCalculationShouldUseCurrentBalance() {
        SavingsAccount interestAccount = new SavingsAccount("S102", "Ravi", 20000, 6, 2000);
        assertEquals(1200, interestAccount.calculateInterest(), 0.001);
    }
}
