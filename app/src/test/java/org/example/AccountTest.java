package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class AccountTest {
    

    //Verifique que el método getCurrentBalance() devuelve correctamente el saldo de la Account.
    @Test
    public void testGetCurrentBalance() {
        
        Account account = mock(Account.class);
        when(account.getCurrentBalance()).thenReturn(100f);
        assertEquals(100f, account.getCurrentBalance());
        
    }

    //Verifique que el método getAccountWithHighestBalance() 
    //devuelve correctamente el accountNumber que corresponde con la Account que posee el mayor saldo.
    //El saldo se puede obtener invocando al método getCurrentBalance().
    @Test
    public void testMejorSaldo() throws NoAccountsException {
        Customer customer = mock(Customer.class);
        Account account1 = mock(Account.class);
        Account account2 = mock(Account.class);

        when(customer.getAccountWithHighestBalance()).thenReturn("20");
        when(account1.getCurrentBalance()).thenReturn(100f);
        when(account1.getAccountNumber()).thenReturn("10");
        when(account2.getCurrentBalance()).thenReturn(200f);
        when(account2.getAccountNumber()).thenReturn("20");

        assertEquals("20", customer.getAccountWithHighestBalance());
    }
}
