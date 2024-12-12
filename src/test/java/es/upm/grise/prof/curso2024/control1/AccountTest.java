package es.upm.grise.prof.curso2024.control1;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    void testGetCurrentBalance() {
        // Arrange
        Account account = new Account();

        setAccountNumber(account, "12345");
        setInitialAmount(account, 100.0f);

        // Crear un mock de Transaction
        Transaction mockTransaction = mock(Transaction.class);
        when(mockTransaction.getAmount()).thenReturn(50.0f);
        addTransactionToAccount(account, mockTransaction);

        // Act
        float result = account.getCurrentBalance();

        // Assert
        assertEquals(150.0f, result, "The balance should be the initial amount plus the transaction amount.");
    }

    // Métodos auxiliares para modificar campos privados mediante reflexión
    private void setAccountNumber(Account account, String accountNumber) {
        try {
            var field = Account.class.getDeclaredField("accountNumber");
            field.setAccessible(true);
            field.set(account, accountNumber);
        } catch (Exception e) {
            fail("Failed to set account number via reflection.");
        }
    }

    private void setInitialAmount(Account account, float amount) {
        try {
            var field = Account.class.getDeclaredField("initialAmount");
            field.setAccessible(true);
            field.set(account, amount);
        } catch (Exception e) {
            fail("Failed to set initial amount via reflection.");
        }
    }

    private void addTransactionToAccount(Account account, Transaction transaction) {
        try {
            var field = Account.class.getDeclaredField("transactions");
            field.setAccessible(true);
            @SuppressWarnings("unchecked")
            var transactions = (java.util.List<Transaction>) field.get(account);
            transactions.add(transaction);
        } catch (Exception e) {
            fail("Failed to add transaction to account via reflection.");
        }
    }
}
