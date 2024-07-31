import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.example.CalculadoraPrincipal

class CalculadoraPrincipal {

    private val calculator = CalculadoraPrincipal()

    @Test
    fun testBasicOperations() {
        assertEquals(8.0, calculator.evaluate("3 + 5"))
        assertEquals(0.0, calculator.evaluate("10 - 2 * 5"))
        assertEquals(21.0, calculator.evaluate("(1 + 2) * (3 + 4)"))
    }

    @Test
    fun testAdvancedOperations() {
        assertEquals(25.0, calculator.evaluate("3 ^ 2 + 4 ^ 2"))
        assertEquals(4.0, calculator.evaluate("2 * (3 + 5) / 4"))
        assertEquals(4.0, calculator.evaluate("2 * ((3 + 5) / 4)"))
    }

    @Test
    fun testErrorHandling() {
        assertThrows(CalculadoraPrincipal.SyntaxError::class.java) {
            calculator.evaluate("3 + (5 * 2")
        }
        assertThrows(CalculadoraPrincipal.DivisionByZeroError::class.java) {
            calculator.evaluate("3 / (3 - 3)")
        }
    }
}

