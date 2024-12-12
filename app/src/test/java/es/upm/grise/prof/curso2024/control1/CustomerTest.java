package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerTest {

    @Test
    void testGetAccountWithHighestBalanceThrowsExceptionWhenNoAccounts() {
        // Arrange: Create a Customer with no accounts
        Customer customer = new Customer();
        // Print to confirm the test is running
        //System.out.println("Running test: testGetAccountWithHighestBalanceThrowsExceptionWhenNoAccounts");

        // Act & Assert: Verify that calling the method throws the NoAccountsException
        assertThrows(NoAccountsException.class, customer::getAccountWithHighestBalance);
    }
}

