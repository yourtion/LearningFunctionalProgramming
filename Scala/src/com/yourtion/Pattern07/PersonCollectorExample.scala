package com.yourtion.Pattern07

/**
  * Created by Yourtion on 20/10/2016.
  */
object PersonCollectorExample {
  case class Person(
                     firstName: Option[String],
                     middleName: Option[String],
                     lastName: Option[String])

  def isFirstNameValid(person: Person) = person.firstName.isDefined

  def isFullNameValid(person: Person) = person match {
    case Person(firstName, middleName, lastName) =>
      firstName.isDefined && middleName.isDefined && lastName.isDefined
  }

  def personCollector(isValid: (Person) => Boolean) = {
    var validPeople = Vector[Person]()
    (person: Person) => {
      if(isValid(person)) validPeople = validPeople :+ person
      validPeople
    }
  }

  def run(): Unit = {
    val p1 = Person(Some("Yourtion"), None, Some("Guo"))
    val p2 = Person(Some("John"), Some("Quincy"), Some("Adams"))
    val p3 = Person(None, Some("John"), Some("Adams"))
    val p4 = Person(None, None, None)

    val personCollector1 = personCollector(isFirstNameValid)
    var result1 = personCollector1(p1)
    result1 = personCollector1(p2)
    result1 = personCollector1(p3)
    result1 = personCollector1(p4)
    println("FirstNameValidator Collector list :")
    println(result1)

    println()

    val personCollector2 = personCollector(isFullNameValid)
    var result2 = personCollector2(p1)
    result2 = personCollector2(p2)
    result2 = personCollector2(p3)
    result2 = personCollector2(p4)
    println("FullNameValidator Collector list :")
    println(result2)

  }
}
