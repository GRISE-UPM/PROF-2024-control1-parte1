package es.upm.grise.prof.curso2024.control1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerTest {

    @Test
    void shouldThrowExceptionWhenNoAccounts() {
        // Crear un cliente sin cuentas
        Customer customer = new Customer();

        // Verificar que se lanza la excepción NoAccountsException
        assertThrows(NoAccountsException.class, customer::getAccountWithHighestBalance);
    }
}
