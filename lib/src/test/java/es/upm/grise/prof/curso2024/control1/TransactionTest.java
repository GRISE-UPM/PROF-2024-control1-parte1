package es.upm.grise.prof.curso2024.control1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    public void testGetAmount() {
        Transaction transaction = new Transaction();
        transaction.amount = 100.0f;

        assertEquals(100.0f, transaction.getAmount());
    }
}