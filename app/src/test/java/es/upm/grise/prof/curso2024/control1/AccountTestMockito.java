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
}
