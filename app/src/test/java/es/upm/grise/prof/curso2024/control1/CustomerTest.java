package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

import es.upm.grise.prof.curso2024.control1.Account;
import es.upm.grise.prof.curso2024.control1.Customer;
import es.upm.grise.prof.curso2024.control1.NoAccountsException;


public class CustomerTest {

    @Test
    //Verifica que el método getAccountWithHighestBalance() lanza una excepción cuando el Customer no tiene asociada ninguna Account
    public void testGetAccountWithHighestBalanceNoAccount(){
        Customer customer = new Customer();
        Exception exception = assertThrows(NoAccountsException.class, customer::getAccountWithHighestBalance);
        assertTrue(exception instanceof NoAccountsException, "Se esperaba una excepción de tipo NoAccountsException");}


    @Test
    //Verifica que el método getAccountWithHighestBalance() devuelve correctamente el accountNumber que corresponde con la Account que posee el mayor saldo. 
    public void testGetAccountWithHighestBalanceCorrectAccount() throws NoAccountsException {
        final String ACCOUNT_1_NUMBER = "12345";
        final String ACCOUNT_2_NUMBER = "67890";
        final float ACCOUNT_1_BALANCE = 500.0f; // Saldo inicial de la primera cuenta
        final float ACCOUNT_2_BALANCE = 1000.0f; // Saldo inicial de la segunda cuenta
    
        Account account1 = new Account();
        account1.setAccount(ACCOUNT_1_NUMBER, ACCOUNT_1_BALANCE);

        Account account2 = new Account();
        account2.setAccount(ACCOUNT_2_NUMBER, ACCOUNT_2_BALANCE);
    
        Customer customer = new Customer();
        List<Account> accountList = customer.getAccounts();
        accountList.add(account1);
        accountList.add(account2);
    
        String result = customer.getAccountWithHighestBalance();
    
        assertEquals(ACCOUNT_2_NUMBER, result, "El método no devolvió el número de cuenta con el saldo más alto.");
    }
}