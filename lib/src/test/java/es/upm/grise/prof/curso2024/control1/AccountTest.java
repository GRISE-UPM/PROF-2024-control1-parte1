package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void testGetCurrentBalance_InitialBalanceAndTransactions() {
        Account account = new Account();

        // Simula transacciones
        Transaction t1 = new Transaction();
        t1.amount = 50.0f;

        Transaction t2 = new Transaction();
        t2.amount = -20.0f;

        account.getTransactions().add(t1);
        account.getTransactions().add(t2);

        // Verifica que el balance sea correcto
        assertEquals(30.0f, account.getCurrentBalance());
    }
}