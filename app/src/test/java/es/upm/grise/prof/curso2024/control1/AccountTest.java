package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AccountTest {

    @Test
    void testGetCurrentBalanceReturnsCorrectBalance() throws Exception {
        // Arrange
        final float INITIAL_AMOUNT = 500.0f;    // Avoid magic number
        final float TRANSACTION_AMOUNT_1 = 200.0f;
        final float TRANSACTION_AMOUNT_2 = -100.0f;

        Account account = new Account();

        Field initialAmountField = Account.class.getDeclaredField("initialAmount");
        initialAmountField.setAccessible(true); // Make it accessible
        initialAmountField.set(account, INITIAL_AMOUNT);

        Field transactionsField = Account.class.getDeclaredField("transactions");
        transactionsField.setAccessible(true); // Make it accessible
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction transaction1 = mock(Transaction.class);
        Transaction transaction2 = mock(Transaction.class);

        when(transaction1.getAmount()).thenReturn(TRANSACTION_AMOUNT_1);
        when(transaction2.getAmount()).thenReturn(TRANSACTION_AMOUNT_2);

        transactions.add(transaction1);
        transactions.add(transaction2);
        transactionsField.set(account, transactions);

        // Act
        float currentBalance = account.getCurrentBalance();

        // Assert
        assertEquals(INITIAL_AMOUNT + TRANSACTION_AMOUNT_1 + TRANSACTION_AMOUNT_2, currentBalance);
    }
}
