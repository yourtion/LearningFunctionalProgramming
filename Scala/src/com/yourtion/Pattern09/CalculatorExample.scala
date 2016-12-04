package com.yourtion.Pattern09

/**
  * Created by Yourtion on 28/11/2016.
  */
object CalculatorExample {

    def add(a: Int, b: Int) = a + b
    def subtract(a: Int, b: Int) = a - b
    def multiply(a: Int, b: Int) = a * b
    def divide(a: Int, b: Int) = a / b

    def makeLogger(calcFn: (Int, Int) => Int) =
      (a: Int, b: Int) => {
        val result = calcFn(a, b)
        println("Result is: " + result)
        result
      }

    val loggingAdd = makeLogger(add)
    val loggingSubtract = makeLogger(subtract)
    val loggingMultiply = makeLogger(multiply)
    val loggingDivide = makeLogger(divide)

  def run(): Unit = {
    println("Without Logging :")

    println(add(1,2))
    println(subtract(4,3))
    println(divide(6,2))
    println(multiply(2,3))

    println()
    println("Logging :")
    println(loggingAdd(1,2))
    println(loggingSubtract(4,3))
    println(loggingDivide(6,2))
    println(loggingMultiply(2,3))

  }

}
