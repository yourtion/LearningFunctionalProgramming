package com.yourtion.Pattern05

/**
  * Created by Yourtion on 11/10/2016.
  */
object HigherOrderFunctions {

  def sumSequence(sequence : Seq[Int]) =
    if(sequence.isEmpty) 0 else sequence.reduce((acc, curr) => acc + curr)

  def prependHello(names : Seq[String]) =
    names.map((name) => "Hello " + name)

  val isVowel = Set('a', 'e', 'i', 'o', 'u')
  def vowelsInWord(word: String) = word.filter(isVowel).toSet

  def run(): Unit = {
    println("vowelsInWord: " + vowelsInWord("Yourtion"))
    println()

    val nameList = Vector("Yourtion", "Sophia")
    println("person: " + nameList)
    println("prependHello: " + prependHello(nameList))
    println()

    val sequence = Vector(1, 2, 3, 4, 5)
    println("sumSequence: "+ sumSequence(sequence))
  }

}
