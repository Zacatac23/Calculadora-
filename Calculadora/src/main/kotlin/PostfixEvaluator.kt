package org.example
fun String.isDouble(): Boolean = this.toDoubleOrNull() != null

object PostfixEvaluator {

    // Evaluar expresión postfija
    fun evaluatePostfix(postfix: List<String>): Double {
        val stack = mutableListOf<Double>()

        for (token in postfix) {
            when {
                token.isDouble() -> stack.add(token.toDouble())
                else -> {
                    val b = stack.removeAt(stack.size - 1)
                    val a = stack.removeAt(stack.size - 1)
                    stack.add(applyOperation(token[0], a, b))
                }
            }
        }

        return stack[0]
    }

    // Aplicar operación matemática
    private fun applyOperation(op: Char, a: Double, b: Double): Double = when (op) {
        '+' -> Operaciones.add(a, b)
        '-' -> Operaciones.subtract(a, b)
        '*' -> Operaciones.multiply(a, b)
        '/' -> Operaciones.divide(a, b)
        '^' -> Operaciones.power(a, b)
        else -> throw CalculadoraPrincipal.SyntaxError("Unknown operator: $op")
    }
}