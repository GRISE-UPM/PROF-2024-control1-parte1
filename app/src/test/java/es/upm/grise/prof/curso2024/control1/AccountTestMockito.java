package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountTestMockito {
    @Test
    public void testMockitoSaldoCorrecto() throws NoAccountsException {
        // Creaamos  un mock de Account
        String mockNumAccount = "44444";
        float mockSaldoAccount = 500.0f;
        Account mockAccount = mock(Account.class);
        when(mockAccount.getAccountNumber()).thenReturn(mockNumAccount);
        when(mockAccount.getCurrentBalance()).thenReturn(mockSaldoAccount);

        // Verificar que el mock responde correctamente
        //assertEquals("12345", mockAccount.getAccountNumber());
        float balanceExpected = 500.0f;
        assertEquals(balanceExpected, mockAccount.getCurrentBalance());
    }

    @Test
    public void testGetCurrentBalanceWithMockTransactions() {

        final float mockSAldoIni = 100.0f;
        final float mockTransac = 50.0f;
        final float mockBalanceExcepted = 150.0f;

        Account account = new Account();
        account.setInitialAmount(mockSAldoIni);

        // Creamos un mock para la transacción
        Transaction mockTransaction = mock(Transaction.class);
        when(mockTransaction.getAmount()).thenReturn(mockTransac);

        // Agregamos la transacción simulada
        account.getTransactions().add(mockTransaction);

        // Testeamos
        float currentBalance = account.getCurrentBalance();
        assertEquals(mockBalanceExcepted, currentBalance);
    }
}
