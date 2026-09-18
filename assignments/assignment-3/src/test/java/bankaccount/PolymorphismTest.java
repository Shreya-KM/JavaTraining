package bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class PolymorphismTest {
    @Test
    void parentReferencesShouldUseOverriddenWithdrawMethods() {
        Account savings = new SavingsAccount("S101", "Ravi", 10000, 6.5, 2000);
        Account current = new CurrentAccount("C101", "Priya", 5000, 10000);
        Account fixedDeposit = new FixedDepositAccount("F101", "Amit", 50000, 7.5, 3);

        assertTrue(savings.withdraw(8000));
        assertTrue(current.withdraw(12000));
        assertFalse(fixedDeposit.withdraw(10000));

        assertEquals(2000, savings.getBalance(), 0.001);
        assertEquals(-7000, current.getBalance(), 0.001);
        assertEquals(50000, fixedDeposit.getBalance(), 0.001);
    }

    @Test
    void accountCollectionShouldApplyAccountSpecificRules() {
        Account savings = new SavingsAccount("S101", "Ravi", 10000, 6.5, 2000);
        Account current = new CurrentAccount("C101", "Priya", 5000, 10000);
        Account fixedDeposit = new FixedDepositAccount("F101", "Amit", 50000, 7.5, 3);
        List<Account> accounts = List.of(savings, current, fixedDeposit);

        for (Account account : accounts) {
            assertTrue(account.deposit(1000));
            account.withdraw(500);
        }

        assertEquals(10500, savings.getBalance(), 0.001);
        assertEquals(5500, current.getBalance(), 0.001);
        assertEquals(51000, fixedDeposit.getBalance(), 0.001);
    }
}
