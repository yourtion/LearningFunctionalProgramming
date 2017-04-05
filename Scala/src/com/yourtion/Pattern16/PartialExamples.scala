package com.yourtion.Pattern16

/**
  * Created by Yourtion on 05/04/2017.
  */
object PartialExamples {

  def addTwoInts(intOne: Int, intTwo: Int) = intOne + intTwo

  def taxForState(amount: Double, state: Symbol) = state match {
    // Simple tax logic, for example only!
    case ('NY) => amount * 0.0645
    case ('PA) => amount * 0.045
    // Rest of states...
  }

  def run(): Unit = {
    println("PartialExamples :")
    val addFortyTwo = addTwoInts(42, _: Int)
    println("100 addFortyTwo: " + addFortyTwo(100))

    val nyTax = taxForState(_: Double, 'NY)
    println("nyTax 100 : " + nyTax(100))

    val paTax = taxForState(_: Double, 'PA)
    println("paTax 100 : " + paTax(100))

  }

}
