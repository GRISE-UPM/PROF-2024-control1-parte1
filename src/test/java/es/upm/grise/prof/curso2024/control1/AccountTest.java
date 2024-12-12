package es.upm.grise.prof.curso2024.control1;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import org.mockito.Mockito.*;
public class AccountTest {
    @Test
    void testGetCurrentBalance() {
        final float initialAmount = 500.0f;
        final float transactionAmount1 = 200.0f;
        final float transactionAmount2 = -150.0f;
        final float expectedBalance = 550.0f;
        Transaction transaction1 = mock(Transaction.class);
        Transaction transaction2 = mock(Transaction.class);
        when(transaction1.getAmount()).thenReturn(transactionAmount1);
        when(transaction2.getAmount()).thenReturn(transactionAmount2);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        Account account = new Account();
        account.setInitialAmount(initialAmount);
        account.setTransactions(transactions);
        float currentBalance = account.getCurrentBalance();
        assertEquals(expectedBalance, currentBalance, 0.001, "El balance actual no es el esperado.");
    }
}
