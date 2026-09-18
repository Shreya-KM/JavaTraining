package bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CurrentAccountTest {
    private CurrentAccount account;

    @BeforeEach
    void setUp() {
        account = new CurrentAccount("C101", "Priya", 5000, 10000);
    }

    @Test
    void accountCreationShouldSetDetails() {
        assertEquals("C101", account.getAccountNumber());
        assertEquals("Priya", account.getHolderName());
        assertEquals(5000, account.getBalance(), 0.001);
    }

    @Test
    void normalWithdrawalShouldReduceBalance() {
        assertTrue(account.withdraw(3000));
        assertEquals(2000, account.getBalance(), 0.001);
    }

    @Test
    void withdrawalWithinOverdraftShouldSucceed() {
        assertTrue(account.withdraw(8000));
        assertEquals(-3000, account.getBalance(), 0.001);
    }

    @Test
    void withdrawalAtOverdraftLimitShouldSucceed() {
        assertTrue(account.withdraw(15000));
        assertEquals(-10000, account.getBalance(), 0.001);
    }

    @Test
    void withdrawalBeyondOverdraftLimitShouldFail() {
        assertFalse(account.withdraw(15001));
        assertEquals(5000, account.getBalance(), 0.001);
    }

    @Test
    void invalidWithdrawalShouldFail() {
        assertFalse(account.withdraw(0));
        assertFalse(account.withdraw(-1));
        assertEquals(5000, account.getBalance(), 0.001);
    }
}
