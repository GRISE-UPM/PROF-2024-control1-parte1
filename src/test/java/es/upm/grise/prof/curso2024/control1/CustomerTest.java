package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    @Test
    public void testThrowsExceptionWhenNoAccounts() {

        Customer customer = new Customer();
        assertThrows(NoAccountsException.class, () -> {
            customer.getAccountWithHighestBalance();
        });
    }
    
    
    @Test
    public void testGetAccountNumber() throws NoAccountsException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

        Customer customer = new Customer();
        Account account1 = new Account();
        Account account2 = new Account();
        
        Field accountNumbers = Account.class.getDeclaredField("accountNumber");
        accountNumbers.setAccessible(true);
        Field initialAmount = Account.class.getDeclaredField("initialAmount");
        initialAmount.setAccessible(true);
        
        Field customerAccounts = Customer.class.getDeclaredField("accounts");
        customerAccounts.setAccessible(true);
        
        List<Account> accounts = new ArrayList<>();
        
        accountNumbers.set(account1, "ACCOUNT1");
        accountNumbers.set(account2, "ACCOUNT2");
        initialAmount.set(account1, 100.00f);
        initialAmount.set(account2, 200.00f);
        
        accounts.add(account1);
        accounts.add(account2);
        customerAccounts.set(customer, accounts);

        assertEquals(account2.getAccountNumber(), customer.getAccountWithHighestBalance(), "Must return accunt 2.");
 
    }
}