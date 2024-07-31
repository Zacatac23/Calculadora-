import org.example.PostfixEvaluator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PostfixEvaluatorTest {

    @Test
    fun testSimplePostfixEvaluation() {
        assertEquals(8.0, PostfixEvaluator.evaluatePostfix(listOf("3", "5", "+")))
        assertEquals(0.0, PostfixEvaluator.evaluatePostfix(listOf("10", "2", "5", "*", "-")))
        assertEquals(21.0, PostfixEvaluator.evaluatePostfix(listOf("1", "2", "+", "3", "4", "+", "*")))
    }

    @Test
    fun testPostfixWithExponentiation() {
        assertEquals(25.0, PostfixEvaluator.evaluatePostfix(listOf("3", "2", "^", "4", "2", "^", "+")))
    }

    @Test
    fun testPostfixWithDivisionByZero() {
        assertThrows(ArithmeticException::class.java) {
            PostfixEvaluator.evaluatePostfix(listOf("1", "0", "/"))
        }
    }
}
