package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun Main() {
    val calculator = ScientificCalculator()

    val expressions = listOf(
        "3 + 5",
        "10 - 2 * 5",
        "(1 + 2) * (3 + 4)", // Resultado esperado: 21
        "3 ^ 2 + 4 ^ 2",     // Resultado esperado: 25
        "2 * (3 + 5) / 4",   // Resultado esperado: 4.0
        "2 * ((3 + 5) / 4)", // Resultado esperado: 4.0
        "((2 + 3) * 2) + 5", // Resultado esperado: 15
        "(2 + 3) * (2 + 5)", // Resultado esperado: 35
        "3 / (3 - 3)"        // Debería lanzar una excepción de división por cero
    )

    for (expr in expressions) {
        try {
            val result = calculator.evaluate(expr)
            println("Resultado de '$expr': $result")
        } catch (e: Exception) {
            println("Error al evaluar '$expr': ${e.message}")
        }
    }
}
