package com.yourtion.Pattern13

import com.yourtion.Pattern13.Phases._

import scala.util.control.TailCalls._

/**
  * Created by Yourtion on 01/04/2017.
  */

object EvenOdd {

  def isOdd(n: Long): Boolean = if (n == 0) false else isEven(n - 1)

  def isEven(n: Long): Boolean = if (n == 0) true else isOdd(n - 1)

  def isOddTrampoline(n: Long): TailRec[Boolean] =
    if (n == 0) done(false) else tailcall(isEvenTrampoline(n - 1))

  def isEvenTrampoline(n: Long): TailRec[Boolean] =
    if (n == 0) done(true) else tailcall(isOddTrampoline(n - 1))
}

object Phases {
  class Transition
  case object Ionization extends Transition
  case object Deionization extends Transition
  case object Vaporization extends Transition
  case object Condensation extends Transition
  case object Freezing extends Transition
  case object Melting extends Transition
  case object Sublimation extends Transition
  case object Deposition extends Transition

  def plasma(transitions: List[Transition]): TailRec[Boolean] = transitions match {
    case Nil => done(true)
    case Deionization :: restTransitions => tailcall(vapor(restTransitions))
    case _ => done(false)
  }
  def vapor(transitions: List[Transition]): TailRec[Boolean] = transitions match {
    case Nil => done(true)
    case Condensation :: restTransitions => tailcall(liquid(restTransitions))
    case Deposition :: restTransitions => tailcall(solid(restTransitions))
    case Ionization :: restTransitions => tailcall(plasma(restTransitions))
    case _ => done(false)
  }

  def liquid(transitions: List[Transition]): TailRec[Boolean] = transitions match {
    case Nil => done(true)
    case Vaporization :: restTransitions => tailcall(vapor(restTransitions))
    case Freezing :: restTransitions => tailcall(solid(restTransitions))
    case _ => done(false)
  }

  def solid(transitions: List[Transition]): TailRec[Boolean] = transitions match {
    case Nil => done(true)
    case Melting :: restTransitions => tailcall(liquid(restTransitions))
    case Sublimation :: restTransitions => tailcall(vapor(restTransitions))
    case _ => done(false)
  }

}

object MutualRecursionExample {
  def run(): Unit = {
    println("Odd or Even :")

    println(EvenOdd.isEvenTrampoline(0).result)
    println(EvenOdd.isOddTrampoline(0).result)
    println(EvenOdd.isOddTrampoline(1000).result)
    println()

    println("Phases :")
    val validSequence = List(Melting, Vaporization, Ionization, Deionization)
    println("solid: " + solid(validSequence).result)

    val invalidSequence = List(Vaporization, Freezing)
    println("liquid: " + liquid(invalidSequence).result)
  }
}
