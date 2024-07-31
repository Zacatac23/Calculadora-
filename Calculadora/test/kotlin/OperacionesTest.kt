import org.example.Operaciones
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OperacionesTest {

    @Test
    fun testAddition() {
        assertEquals(7.0, Operaciones.add(3.0, 4.0))
        assertEquals(0.0, Operaciones.add(-2.0, 2.0))
        assertEquals(-5.0, Operaciones.add(-2.0, -3.0))
    }

    @Test
    fun testSubtraction() {
        assertEquals(1.0, Operaciones.subtract(5.0, 4.0))
        assertEquals(-4.0, Operaciones.subtract(-2.0, 2.0))
        assertEquals(1.0, Operaciones.subtract(-2.0, -3.0))
    }

    @Test
    fun testMultiplication() {
        assertEquals(12.0, Operaciones.multiply(3.0, 4.0))
        assertEquals(-6.0, Operaciones.multiply(-2.0, 3.0))
        assertEquals(0.0, Operaciones.multiply(0.0, 5.0))
    }

    @Test
    fun testDivision() {
        assertEquals(2.0, Operaciones.divide(10.0, 5.0))
        assertEquals(-2.0, Operaciones.divide(-6.0, 3.0))
        assertThrows(ArithmeticException::class.java) { Operaciones.divide(1.0, 0.0) }
    }

    @Test
    fun testPower() {
        assertEquals(9.0, Operaciones.power(3.0, 2.0))
        assertEquals(1.0, Operaciones.power(5.0, 0.0))
        assertEquals(0.25, Operaciones.power(2.0, -2.0))
    }
}
