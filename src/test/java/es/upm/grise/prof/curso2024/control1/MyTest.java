package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class MyTest {

    final float WEAK_INITIAL_AMOUNT = 0.0f, STRONG_INITIAL_AMOUNT = 10.0f;
    final String WEAK_ACCOUNT_NUMBER = new String("0"), STRONG_ACCOUNT_NUMBER = new String("1");

    @Test
    public void testPregunta2(){

        Customer customer = new Customer();

        assertThrows(NoAccountsException.class, () -> {
            customer.getAccountWithHighestBalance();

        });
    }

    @Test
    public void testPregunta3() throws NoAccountsException{
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
    @Test public void testPregunta5() throws NoAccountsException{
        Transaction transaction1 = mock(Transaction.class);
        Transaction transaction2 = mock(Transaction.class);

        final float AMOUNT_ONE = 1.0f;
        
        when(transaction1.getAmount()).thenReturn(AMOUNT_ONE);
        when(transaction2.getAmount()).thenReturn(AMOUNT_ONE);
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction1);
        transactions.add(transaction2);

        Account account = new Account();
        account.transactions = transactions;
        account.initialAmount = AMOUNT_ONE;

        assertEquals(account.getCurrentBalance(), AMOUNT_ONE*3);
        verify(transaction1).getAmount();
        verify(transaction2).getAmount();

    }
    @Test public void testPregunta6() throws NoAccountsException{

        Customer customer = new Customer();

        
        Account weakAccount = mock(Account.class);
        when(weakAccount.getCurrentBalance()).thenReturn(WEAK_INITIAL_AMOUNT);
        when(weakAccount.getAccountNumber()).thenReturn(WEAK_ACCOUNT_NUMBER);

        Account strongAccount = mock(Account.class);
        when(strongAccount.getCurrentBalance()).thenReturn(STRONG_INITIAL_AMOUNT);
        when(strongAccount.getAccountNumber()).thenReturn(STRONG_ACCOUNT_NUMBER);
        customer.accounts.add(weakAccount);
        customer.accounts.add(strongAccount);

        assertEquals(customer.getAccountWithHighestBalance(), STRONG_ACCOUNT_NUMBER);
        verify(weakAccount).getCurrentBalance();
        verify(strongAccount).getCurrentBalance();
        verify(strongAccount).getAccountNumber();
    }
}
