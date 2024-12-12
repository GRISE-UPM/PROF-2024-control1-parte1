package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class MyTest {

    @Test
    public void testPregunta2(){

        Customer customer = new Customer();

        assertThrows(NoAccountsException.class, () -> {
            customer.getAccountWithHighestBalance();

        });
    }

    @Test
    public void testPregunta3() throws NoAccountsException{

        final int WEAK_INITIAL_AMOUNT = 0, STRONG_INITIAL_AMOUNT = 10;
        assert(WEAK_INITIAL_AMOUNT < STRONG_INITIAL_AMOUNT);
        final String WEAK_ACCOUNT_NUMBER = new String("0"), STRONG_ACCOUNT_NUMBER = new String("1");

        Customer customer = new Customer();
        Account weakAccount = new Account();
        weakAccount.initialAmount = WEAK_INITIAL_AMOUNT;
        weakAccount.accountNumber = WEAK_ACCOUNT_NUMBER;

        Account strongAccount = new Account();
        strongAccount.initialAmount = STRONG_INITIAL_AMOUNT;
        strongAccount.accountNumber = STRONG_ACCOUNT_NUMBER;
        

        customer.accounts.add(weakAccount);
        customer.accounts.add(strongAccount);

        assertEquals(customer.getAccountWithHighestBalance(), STRONG_ACCOUNT_NUMBER);

    }
}
