package com.yourtion.Pattern05

/**
  * Created by Yourtion on 11/10/2016.
  */
object TheLambdaBarAndGrille {

  case class Person(name: String, address: Address)
  case class Address(zip: Int)

  def generateGreetings(people: Seq[Person]) =
    for (Person(name, address) <- people if isCloseZip(address.zip))
      yield "Hello, %s, and welcome to the Lambda Bar And Grille!".format(name)
  def isCloseZip(zipCode: Int) = zipCode == 19123 || zipCode == 19103

  def printGreetings(people: Seq[Person]) =
    for (Person(name, address) <- people if isCloseZip(address.zip))
      println("Hello, %s, and welcome to the Lambda Bar And Grille!".format(name))

  def run(): Unit = {
    var persons = Seq[Person]();
    persons = persons :+ Person("Yourtion1", Address(19123))
    persons = persons :+ Person("Yourtion2", Address(19103))
    persons = persons :+ Person("Yourtion3", Address(19129))
    persons = persons :+ Person("Yourtion4", Address(19103))
    persons = persons :+ Person("Yourtion5", Address(19111))

    println("All person: " + persons)
    println(generateGreetings(persons))
    println("-------------")
    printGreetings(persons)
  }
}
