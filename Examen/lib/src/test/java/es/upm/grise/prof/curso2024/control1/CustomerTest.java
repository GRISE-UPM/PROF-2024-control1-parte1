package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testGetAccountWithHighestBalance_NoAccounts_ThrowsException() {
        Customer customer = new Customer();
        
        // Verifica que lanzar una excepción funciona
        assertThrows(NoAccountsException.class, customer::getAccountWithHighestBalance);
    }
}
