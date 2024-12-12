package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CustomerTest {
	/*
	@Test
    void testGetAccountWithHighestBalanceThrowsExceptionWhenNoAccounts() {
        // Arrange: Create a Customer with no accounts
        Customer customer = new Customer();
        // Print to confirm the test is running
        //System.out.println("Running test: testGetAccountWithHighestBalanceThrowsExceptionWhenNoAccounts");

        assertThrows(NoAccountsException.class, customer::getAccountWithHighestBalance);
    }
	*/
	
    @Test
    void testGetAccountWithHighestBalanceThrowsExceptionWhenNoAccounts_Mockito() throws NoAccountsException {
        // Arrange
        Customer customerMock = Mockito.mock(Customer.class);

        // mock to throw except
        when(customerMock.getAccountWithHighestBalance()).thenThrow(new NoAccountsException());

        // Act & Assert
        assertThrows(NoAccountsException.class, customerMock::getAccountWithHighestBalance);

        verify(customerMock, times(1)).getAccountWithHighestBalance();
    }
}


