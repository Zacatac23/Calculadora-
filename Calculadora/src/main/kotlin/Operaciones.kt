package org.example

import kotlin.math.pow


object Operaciones {

    // Métodos de operaciones básicas
    fun add(a: Double, b: Double): Double = a + b
    fun subtract(a: Double, b: Double): Double = a - b
    fun multiply(a: Double, b: Double): Double = a * b
    fun divide(a: Double, b: Double): Double {
        if (b == 0.0) throw ArithmeticException("Division by zero")
        return a / b
    }

    fun power(base: Double, exponent: Double): Double = base.pow(exponent)
    fun sqrt(value: Double): Double = kotlin.math.sqrt(value)
    fun exp(value: Double): Double = kotlin.math.exp(value)
}