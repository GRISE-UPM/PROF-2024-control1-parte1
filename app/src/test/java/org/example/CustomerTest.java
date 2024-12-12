package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CustomerTest {
    @Test
    public void testNoAccountsException() {
        Customer customer = new Customer();
        assertThrows(NoAccountsException.class, () -> {
            customer.getAccountWithHighestBalance();
        });
    }
        //Verifique que el método getAccountWithHighestBalance() 
    //devuelve correctamente el accountNumber que corresponde con la Account que posee el mayor saldo.
    //El saldo se puede obtener invocando al método getCurrentBalance().
    @Test
    public void testMejorSaldo() throws NoAccountsException {
        Customer customer = new Customer();
        Account account1 = new Account(100, "10");
        Account account2 = new Account(200, "20");

        customer.addAccount(account1);
        customer.addAccount(account2);

        assertEquals("20", customer.getAccountWithHighestBalance());
    }

}
