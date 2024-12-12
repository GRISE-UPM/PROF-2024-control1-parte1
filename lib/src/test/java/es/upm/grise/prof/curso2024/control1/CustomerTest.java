package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CustomerTest {
	
	// Constantes para evitar Magic Numbers
    private static final float SALDO_CUENTA_1 = 500.0f;
    private static final float SALDO_CUENTA_2 = 1000.0f;

    @Test
    public void testGetAccountWithHighestBalance_NoAccounts_ThrowsException() {
        // Crear un objeto Customer sin cuentas
        Customer customer = new Customer();

        // Verificar que el método lanza la excepción NoAccountsException cuando no hay cuentas
        assertThrows(NoAccountsException.class, () -> {
            customer.getAccountWithHighestBalance();
        });
    }
    
    @Test
    public void testGetAccountWithHighestBalance_ReturnsCorrectAccount() throws NoAccountsException {
        // Crear las cuentas
        Account cuenta1 = new Account();
        cuenta1.setAccountNumber("123");
        cuenta1.setInitialAmount(SALDO_CUENTA_1);

        Account cuenta2 = new Account();
        cuenta2.setAccountNumber("456");
        cuenta2.setInitialAmount(SALDO_CUENTA_2);

        // Crear el cliente y asociar las cuentas
        Customer customer = new Customer();
        customer.getAccounts().add(cuenta1);
        customer.getAccounts().add(cuenta2);

        // Verificar que el método devuelve el accountNumber correcto
        String accountNumberWithHighestBalance = customer.getAccountWithHighestBalance();
        assertEquals("456", accountNumberWithHighestBalance);
    }
}