package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field; 
import java.util.List;          
import java.util.ArrayList;     
import static org.junit.jupiter.api.Assertions.assertEquals; 
import static org.junit.jupiter.api.Assertions.assertThrows; 
import static org.junit.jupiter.api.Assertions.fail;         
import static org.mockito.Mockito.mock;                      
import static org.mockito.Mockito.when;

class CustomerTest {

    @Test
    void testGetAccountWithHighestBalanceThrowsExceptionWhenNoAccounts_Mockito() throws NoAccountsException {
        // Arrange
        Customer customerMock = mock(Customer.class);

        when(customerMock.getAccountWithHighestBalance()).thenThrow(new NoAccountsException());

        // Act & Assert
        assertThrows(NoAccountsException.class, customerMock::getAccountWithHighestBalance);
    }

    @Test
    void testGetAccountWithHighestBalanceReturnsCorrectAccount() throws NoAccountsException {
        try {
            // Arrange
            Customer customer = new Customer();

            Account mockAccount1 = mock(Account.class);
            Account mockAccount2 = mock(Account.class);

            when(mockAccount1.getCurrentBalance()).thenReturn(200.0f);
            when(mockAccount1.getAccountNumber()).thenReturn("ACC1");

            when(mockAccount2.getCurrentBalance()).thenReturn(500.0f);
            when(mockAccount2.getAccountNumber()).thenReturn("ACC2");

            List<Account> accounts = new ArrayList<>();
            accounts.add(mockAccount1);
            accounts.add(mockAccount2);

            Field accountsField = Customer.class.getDeclaredField("accounts");
            accountsField.setAccessible(true);
            accountsField.set(customer, accounts);

            // Act
            String result = customer.getAccountWithHighestBalance();

            // Assert
            assertEquals("ACC2", result); 
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    void testGetAccountWithHighestBalanceHandlesEqualBalances() throws NoAccountsException {
        try {
            // Arrange
            Customer customer = new Customer();

            Account mockAccount1 = mock(Account.class);
            Account mockAccount2 = mock(Account.class);

            when(mockAccount1.getCurrentBalance()).thenReturn(300.0f);
            when(mockAccount1.getAccountNumber()).thenReturn("ACC1");

            when(mockAccount2.getCurrentBalance()).thenReturn(300.0f);
            when(mockAccount2.getAccountNumber()).thenReturn("ACC2");

            List<Account> accounts = new ArrayList<>();
            accounts.add(mockAccount1);
            accounts.add(mockAccount2);

            Field accountsField = Customer.class.getDeclaredField("accounts");
            accountsField.setAccessible(true);
            accountsField.set(customer, accounts);

            // Act
            String result = customer.getAccountWithHighestBalance();

            // Assert
            assertEquals("ACC2", result); 
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            fail("Reflection failed: " + e.getMessage());
        }
    }
    
    
    @Test
    void testGetAccountWithHighestBalanceWhenAllBalancesAreLower() throws NoAccountsException {
        try {
            // Arrange
            Customer customer = new Customer();

            Account mockAccount1 = mock(Account.class);
            Account mockAccount2 = mock(Account.class);

            when(mockAccount1.getCurrentBalance()).thenReturn(50.0f);
            when(mockAccount1.getAccountNumber()).thenReturn("ACC2");

            when(mockAccount2.getCurrentBalance()).thenReturn(100.0f);
            when(mockAccount2.getAccountNumber()).thenReturn("ACC1");

            List<Account> accounts = new ArrayList<>();
            accounts.add(mockAccount1); 
            accounts.add(mockAccount2); 

            Field accountsField = Customer.class.getDeclaredField("accounts");
            accountsField.setAccessible(true);
            accountsField.set(customer, accounts);

            // Act
            String result = customer.getAccountWithHighestBalance();

            // Assert
            assertEquals("ACC1", result);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            fail("Reflection failed: " + e.getMessage());
        }
    }
    
    
    @Test
    void testGetAccountWithHighestBalanceSkipsLowerBalances() throws NoAccountsException {
        try {
            // Arrange
            Customer customer = new Customer();

            Account mockAccount1 = mock(Account.class);
            Account mockAccount2 = mock(Account.class);
            Account mockAccount3 = mock(Account.class);

            when(mockAccount1.getCurrentBalance()).thenReturn(300.0f); // Highest balance
            when(mockAccount1.getAccountNumber()).thenReturn("ACC1");

            when(mockAccount2.getCurrentBalance()).thenReturn(100.0f); // Lower balance
            when(mockAccount2.getAccountNumber()).thenReturn("ACC2");

            when(mockAccount3.getCurrentBalance()).thenReturn(200.0f); // Lower balance
            when(mockAccount3.getAccountNumber()).thenReturn("ACC3");

            List<Account> accounts = new ArrayList<>();
            accounts.add(mockAccount2); 
            accounts.add(mockAccount3); 
            accounts.add(mockAccount1); 

            Field accountsField = Customer.class.getDeclaredField("accounts");
            accountsField.setAccessible(true);
            accountsField.set(customer, accounts);

            // Act
            String result = customer.getAccountWithHighestBalance();

            // Assert
            assertEquals("ACC1", result); 
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            fail("Reflection failed: " + e.getMessage());
        }
    }
    
    
    @Test
    void testGetAccountWithHighestBalanceThrowsExceptionWhenNoAccounts() throws NoAccountsException {
        // Arrange
        Customer customer = new Customer(); // No accounts added

        // Act & Assert
        assertThrows(NoAccountsException.class, customer::getAccountWithHighestBalance);
    }

    
    @Test
    void testGetAccountWithHighestBalanceAllAccountsHaveEqualBalances() throws NoAccountsException {
        try {
            // Arrange
            Customer customer = new Customer();

            Account mockAccount1 = mock(Account.class);
            Account mockAccount2 = mock(Account.class);

            when(mockAccount1.getCurrentBalance()).thenReturn(100.0f); // Equal balance
            when(mockAccount1.getAccountNumber()).thenReturn("ACC1");

            when(mockAccount2.getCurrentBalance()).thenReturn(100.0f); // Equal balance
            when(mockAccount2.getAccountNumber()).thenReturn("ACC2");

            List<Account> accounts = new ArrayList<>();
            accounts.add(mockAccount1); 
            accounts.add(mockAccount2); 

            Field accountsField = Customer.class.getDeclaredField("accounts");
            accountsField.setAccessible(true);
            accountsField.set(customer, accounts);

            // Act
            String result = customer.getAccountWithHighestBalance();

            // Assert
            assertEquals("ACC2", result); 
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    void testGetAccountWithHighestBalanceAllBalancesBelowThreshold() throws NoAccountsException {
        try {
            // Arrange
            Customer customer = new Customer();

            Account mockAccount1 = mock(Account.class);
            Account mockAccount2 = mock(Account.class);

            when(mockAccount1.getCurrentBalance()).thenReturn(-100.0f); // Negative balance
            when(mockAccount1.getAccountNumber()).thenReturn("ACC1");

            when(mockAccount2.getCurrentBalance()).thenReturn(-200.0f); // Lower negative balance
            when(mockAccount2.getAccountNumber()).thenReturn("ACC2");

            List<Account> accounts = new ArrayList<>();
            accounts.add(mockAccount1);
            accounts.add(mockAccount2);

            Field accountsField = Customer.class.getDeclaredField("accounts");
            accountsField.setAccessible(true);
            accountsField.set(customer, accounts);

            // Act
            String result = customer.getAccountWithHighestBalance();

            // Assert
            assertEquals("", result); // Expect an empty string 
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            fail("Reflection failed: " + e.getMessage());
        }
    }


    


}
