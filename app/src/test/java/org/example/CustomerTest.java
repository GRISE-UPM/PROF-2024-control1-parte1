package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void testGetAccountWithHighestBalanceWhenNoAccounts() {
        Customer emptyCustomer = new Customer();
        assertThrows(NoAccountsException.class, emptyCustomer::getAccountWithHighestBalance);
    }

    @Test
    /*Verifique que el método getAccountWithHighestBalance() devuelve correctamente el accountNumber
     que corresponde con la Account que posee el mayor saldo. 
     El saldo se puede obtener invocando al método getCurrentBalance(). */
     void testGetAccountWithHighestBalance() throws NoAccountsException{
        Customer customer = new Customer();
        Account account1 = new Account();
        Account account2 = new Account();
        final float TRANSACTION_1 = 100.0f;
        final float TRANSACTION_2 = 200.0f;
        final float TRANSACTION_3 = 300.0f;
        final float TRANSACTION_4 = 400.0f;
        account1.addTransaction(new Transaction("Transaction 1", TRANSACTION_1));
        account1.addTransaction(new Transaction("Transaction 2", TRANSACTION_2));
        account2.addTransaction(new Transaction("Transaction 3", TRANSACTION_3));
        account2.addTransaction(new Transaction("Transaction 4", TRANSACTION_4));
        customer.addTransaction(account1);
        customer.addTransaction(account2);
        assertEquals(account2.getAccountNumber(), customer.getAccountWithHighestBalance());
     }
}
