package com.yourtion.Pattern01

/**
  * Created by Yourtion on 9/7/16.
  */
object PersonExample {
  (int1: Int, int2: Int) => int1 + int2

  case class Person(firstName: String, lastName: String)

  val p1 = Person("Michael", "Bevilacqua")
  val p2 = Person("Pedro", "Vasquez")
  val p3 = Person("Robert", "Aarons")

  val people = Vector(p3, p2, p1)

  val sorted_people = people.sortWith((p1, p2) => p1.firstName < p2.firstName)

  def run() = {
    sorted_people.foreach(p => println(p.firstName, p.lastName))
  }
}
