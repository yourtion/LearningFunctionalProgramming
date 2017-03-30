package com.yourtion.Pattern10

/**
  * Created by Yourtion on 29/03/2017.
  */
object VisitorExample {

  trait Person {
    def fullName: String
    def firstName: String
    def lastName: String
    def houseNum: Int
    def street: String
  }

  class SimplePerson(val firstName: String, val lastName: String,
                     val houseNum: Int, val street: String) extends Person {
    def fullName = firstName + " " + lastName
  }

  class ComplexPerson(name: Name, address: Address) extends Person {
    def fullName = name.firstName + " " + name.lastName

    def firstName = name.firstName
    def lastName = name.lastName
    def houseNum = address.houseNum
    def street = address.street
  }
  class Address(val houseNum: Int, val street: String)
  class Name(val firstName: String, val lastName: String)

  implicit class ExtendedPerson(person: Person) {
    def fullAddress = person.houseNum + " " + person.street
  }

  def run(): Unit = {
    println("SimplePerson :")

    val simplePerson = new SimplePerson("Yourtion", "Guo", 123, "Fake. St.")
    println(simplePerson)
    println("FullName:" + simplePerson.fullName)
    println("FullAddress:" + simplePerson.fullAddress)
    println()

    println("ComplexPerson :")
    val name = new Name("yourtion", "guo")
    val address = new Address(456, "Fake2. St.")
    val complexPerson = new ComplexPerson(name, address)
    println("FullName:" + complexPerson.fullName)
    println("FullAddress:" + complexPerson.fullAddress)
  }

}
