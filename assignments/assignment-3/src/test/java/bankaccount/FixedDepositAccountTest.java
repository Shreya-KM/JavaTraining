package bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FixedDepositAccountTest {
    private FixedDepositAccount account;

    @BeforeEach
    void setUp() {
        account = new FixedDepositAccount("F101", "Amit", 50000, 7.5, 3);
    }

    @Test
    void accountCreationShouldSetDetails() {
        assertEquals("F101", account.getAccountNumber());
        assertEquals("Amit", account.getHolderName());
        assertEquals(50000, account.getBalance(), 0.001);
    }

    @Test
    void maturityAmountShouldBeCalculatedCorrectly() {
        assertEquals(61250, account.calculateMaturityAmount(), 0.001);
    }

    @Test
    void withdrawalShouldAlwaysBeRejected() {
        assertFalse(account.withdraw(10000));
        assertEquals(50000, account.getBalance(), 0.001);
    }

    @Test
    void depositShouldIncreaseBalance() {
        assertTrue(account.deposit(2000));
        assertEquals(52000, account.getBalance(), 0.001);
    }
}
