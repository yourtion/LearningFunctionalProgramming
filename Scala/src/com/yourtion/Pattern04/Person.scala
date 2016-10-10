package com.yourtion.Pattern04

/**
  * Created by Yourtion on 10/10/2016.
  */
class Person(
    val firstName: String,
    val middleName: String,
    val lastName: String)
{
  override def toString: String = "%s %s %s".format(firstName, middleName, lastName)
}

class PersonWithDefault(
                         val firstName: String,
                         val middleName: String = "",
                         val lastName: String)
{
  override def toString: String = "%s %s %s".format(firstName, middleName, lastName)
}

case class PersonCaseClass(
                            firstName: String,
                            middleName: String = "",
                            lastName: String = "")
{
  override def toString: String = "%s %s %s".format(firstName, middleName, lastName)
}

object PersonHarness {
  def run(): Unit = {
    println("# simple class with val")
    val p1 = new Person("John", "Quincy", "Adams")
    println("Person1 is: " + p1.toString)
    val p2 = new Person(firstName = "John",middleName = "Quincy",lastName = "Adams")
    println("Person2 is: " + p2.toString)
    println("Person1 is equals Person2 : " + p1.equals(p2))
    println()

    println("class with Default")
    val p3 = new PersonWithDefault(firstName = "Yourtion", lastName = "Guo")
    println("Person3 is: " + p3.toString)
    val p4 = new PersonWithDefault(firstName = "Yourtion", lastName = "Guo")
    println("Person4 is: " + p4.toString)
    println("Person3 is equals Person4 : " + p3.equals(p4))
    println()

    println("# case class with Default")
    val p5 = PersonCaseClass(firstName = "Yourtion")
    println("Person5 is: " + p5.toString)
    val p6 = PersonCaseClass(firstName = "Yourtion")
    println("Person6 is: " + p6.toString)
    println("Person5 is equals Person6 : " + p5.equals(p6))
    val p7 = PersonCaseClass(firstName = "Yourtion", lastName = "Guo")
    println("Person7 is: " + p7.toString)
    println("Person6 is equals Person7 : " + p6.equals(p7))
    val p8 = p5.copy(lastName = "Guo")
    println("Person8 is: " + p7.toString)
    println("Person7 is equals Person8 : " + p8.equals(p8))

    val p9 = p8 match {
      case PersonCaseClass(firstName, middleName, lastName) => {
        "First: %s - Middle: %s - Last: %s".format(firstName, middleName, lastName)
      }
    }
    println("Person9 is: " + p9.toString)
    println()

    println("# use tuple")
    def p = ("Yourtion", "Guo")
    println("Person is: " + p._1 + " " + p._2 )

    p match {
      case (firstName, lastName) => {
        println("First name is: " + firstName)
        println("Last name is: " + lastName)
      }
    }




  }
}