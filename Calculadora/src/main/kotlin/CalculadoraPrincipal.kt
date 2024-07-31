package org.example

class CalculadoraPrincipal {

    // Método principal para evaluar la expresión
    fun evaluate(expression: String): Double {
        try {
            val postfix = Expresiones.infixToPostfix(expression)
            return PostfixEvaluator.evaluatePostfix(postfix)
        } catch (e: ArithmeticException) {
            throw DivisionByZeroError()
        } catch (e: Exception) {
            throw SyntaxError("Invalid expression: ${e.message}")
        }
    }

    // Excepciones personalizadas
    class SyntaxError(message: String) : Exception(message)
    class DivisionByZeroError : Exception("Division by zero error")
}