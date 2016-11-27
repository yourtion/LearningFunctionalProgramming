package com.yourtion.Pattern08

/**
  * Created by Yourtion on 23/11/2016.
  */
object PersonExamples {
  case class Person(firstName: String="John", lastName: String="Doe")
  val nullPerson = Person()

  def fetchPerson(people: Map[Int, Person], id: Int) =
    people.getOrElse(id, nullPerson)

  def buildPerson(firstNameOption: Option[String], lastNameOption: Option[String]) =
    (for(
      firstName <- firstNameOption;
      lastName <- lastNameOption)
      yield Person(firstName, lastName)).getOrElse(Person("John", "Doe"))


  def run(): Unit = {
    println("BuildPerson :")

    println("Not null: ", buildPerson(Option("Yourtion"),Option("Guo")))
    println("Null firstlast name: ", buildPerson(None,Option("Guo")))
    println("Null last name: ", buildPerson(Option("Yourtion"),None))

    val yourtion = Person("Yourtion", "Guo")
    val somePeople = Map(1 -> yourtion)

    println()
    println("FetchPerson :")

    println("Not null: ", fetchPerson(somePeople,1))
    println("Null: ", fetchPerson(somePeople,2))

  }
}
