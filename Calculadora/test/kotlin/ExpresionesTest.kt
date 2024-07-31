import org.example.Expresiones
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.example.CalculadoraPrincipal
class ExpressionParserTest {

    @Test
    fun testInfixToPostfix() {
        assertEquals(listOf("3", "5", "+"), Expresiones.infixToPostfix("3 + 5"))
        assertEquals(listOf("10", "2", "5", "*", "-"), Expresiones.infixToPostfix("10 - 2 * 5"))
        assertEquals(listOf("1", "2", "+", "3", "4", "+", "*"), Expresiones.infixToPostfix("(1 + 2) * (3 + 4)"))
    }

    @Test
    fun testInfixWithExponentiation() {
        assertEquals(listOf("3", "2", "^", "4", "2", "^", "+"), Expresiones.infixToPostfix("3 ^ 2 + 4 ^ 2"))
    }

    @Test
    fun testInfixWithParentheses() {
        assertEquals(listOf("2", "3", "+", "5", "6", "+", "*"), Expresiones.infixToPostfix("(2 + 3) * (5 + 6)"))
        assertThrows(CalculadoraPrincipal.SyntaxError::class.java) {
            Expresiones.infixToPostfix("(2 + 3 * (5 + 6)")
        }
    }
}
