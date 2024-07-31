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
        '+' -> Operations.add(a, b)
        '-' -> Operations.subtract(a, b)
        '*' -> Operations.multiply(a, b)
        '/' -> Operations.divide(a, b)
        '^' -> Operations.power(a, b)
        else -> throw ScientificCalculator.SyntaxError("Unknown operator: $op")
    }
}
