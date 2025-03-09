import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class BankAccountAssumptionTest {
    @Test
    @DisplayName("Test Activation account after creation")
    public void testActive() {
        BankAccount bankAccount = new BankAccount(500, 0);
//        Assumptions.assumeTrue(bankAccount == null, "Account is null");
//        assertTrue(bankAccount.isActive());
        assumingThat(bankAccount != null, () -> assertTrue(bankAccount.isActive()));

    }
}
