import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BankAccountAssertionsTest")
public class BankAccountAssertionsTest {
    @Test
    @DisplayName("Withdraw 500 Succesfully")
    public void testWithdrawal() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        Assertions.assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully")
    public void testDeposit() {
        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.deposit(500);
        Assertions.assertEquals(900, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Withdraw will become negative")
    public void testWithdrawNotStuckAtZero() {
        BankAccount bankAccount = new BankAccount(400, -1000);
        bankAccount.withdraw(800);
        Assertions.assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test activation account after creation")
    public void testActive() {
        BankAccount bankAccount = new BankAccount(500, 0);
        Assertions.assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test set holder name")
    public void testHolderNameSet(){
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.setHolderName("John Doe");
        Assertions.assertNotNull(bankAccount.getHolderName());
    }

    @Test
    @DisplayName("Test that we can't withdraw below Minimum")
    public void testWithdrawBelowMinimum() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        Assertions.assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
    }

    @Test
    @DisplayName("Test no exceptions for withdraw and deposit")
    public void testWithdrawAndDepositWithNoExceptions() {
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertAll(String.valueOf(RuntimeException.class), () -> bankAccount.deposit(2000),
                () -> bankAccount.withdraw(2500));
    }

    @Test
    @DisplayName("Test speed deposit")
    public void testDepositTimeout() {
        BankAccount bankAccount = new BankAccount(500, 0);
        assertTimeout(Duration.ofNanos(10), () -> bankAccount.deposit(200));
        assertEquals(0.33, 1/3, 0.01, "Speed deposit failed");
    }
}