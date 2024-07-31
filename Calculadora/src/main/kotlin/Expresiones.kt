object Expresiones {

    // Convertir expresión infija a postfija
    fun infixToPostfix(expression: String): List<String> {
        val output = mutableListOf<String>()
        val operators = mutableListOf<Char>()
        var i = 0

        while (i < expression.length) {
            val c = expression[i]

            when {
                c.isWhitespace() -> i++
                c.isDigit() || c == '.' -> {
                    val number = StringBuilder()
                    while (i < expression.length && (expression[i].isDigit() || expression[i] == '.')) {
                        number.append(expression[i])
                        i++
                    }
                    output.add(number.toString())
                }
                c == '(' -> {
                    operators.add(c)
                    i++
                }
                c == ')' -> {
                    while (operators.isNotEmpty() && operators.last() != '(') {
                        output.add(operators.removeAt(operators.size - 1).toString())
                    }
                    if (operators.isNotEmpty() && operators.last() == '(') {
                        operators.removeAt(operators.size - 1)
                    } else {
                        throw ScientificCalculator.SyntaxError("Mismatched parentheses")
                    }
                    i++
                }
                else -> {
                    while (operators.isNotEmpty() && precedence(c) <= precedence(operators.last())) {
                        output.add(operators.removeAt(operators.size - 1).toString())
                    }
                    operators.add(c)
                    i++
                }
            }
        }

        while (operators.isNotEmpty()) {
            val op = operators.removeAt(operators.size - 1)
            if (op == '(' || op == ')') throw ScientificCalculator.SyntaxError("Mismatched parentheses")
            output.add(op.toString())
        }

        return output
    }

    // Precedencia de operadores
    private fun precedence(op: Char): Int = when (op) {
        '+', '-' -> 1
        '*', '/' -> 2
        '^' -> 3
        else -> 0
    }
}