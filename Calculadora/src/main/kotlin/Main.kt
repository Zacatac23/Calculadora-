package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val calculator = CalculadoraPrincipal()

    while (true) {
        println("Ingrese una expresión matemática (o 'exit' para salir):")
        val input = readLine()

        if (input.isNullOrBlank()) {
            println("La entrada no puede estar vacía. Inténtalo de nuevo.")
            continue
        }

        if (input == "exit") {
            println("Saliendo...")
            break
        }

        try {
            val result = calculator.evaluate(input)
            println("Resultado: $result")
        } catch (e: CalculadoraPrincipal.SyntaxError) {
            println("Error de sintaxis: ${e.message}")
        } catch (e: CalculadoraPrincipal.DivisionByZeroError) {
            println("Error: División por cero no permitida.")
        } catch (e: Exception) {
            println("Error al evaluar la expresión: ${e.message}")
        }
    }
}
