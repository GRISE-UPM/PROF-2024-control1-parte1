package es.upm.grise.prof.curso2024.control1;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AccountMockitoTest {

    // Constante para evitar el uso de Magic Number
    private static final float SALDO_CUENTA = 1000.0f;

    @Test
    public void testGetCurrentBalance_ReturnsCorrectBalance() {
        // Crear un mock de la clase Account
        Account mockAccount = mock(Account.class);

        // Configurar el comportamiento del mock
        when(mockAccount.getCurrentBalance()).thenReturn(SALDO_CUENTA);

        // Verificar que el método devuelve el saldo correcto
        float balance = mockAccount.getCurrentBalance();
        assertEquals(SALDO_CUENTA, balance, "El saldo debe ser el mismo que el configurado");
    }
}
