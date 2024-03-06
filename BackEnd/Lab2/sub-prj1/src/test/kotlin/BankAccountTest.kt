import org.example.BankAccount
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.math.BigDecimal

class BankAccountTest {

    val bankAccount = BankAccount("Mark", "Petrov", BigDecimal(500))

    @Test
    fun deposit() {
        val balance = bankAccount.deposit(BigDecimal(200))
        assertEquals(balance, BigDecimal(700))
    }

    @Test
    fun withdraw() {
        val balance = bankAccount.withdraw(BigDecimal(200))
        assertEquals(balance, BigDecimal(300))
    }
}