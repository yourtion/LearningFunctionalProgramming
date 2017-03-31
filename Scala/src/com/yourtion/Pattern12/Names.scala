package com.yourtion.Pattern12
import scala.annotation.tailrec

/**
  * Created by Yourtion on 31/03/2017.
  */
object Names {

  case class Person(firstNames: String, lastNames: String)

  /*
  val makePeople = (firstNames: Seq[String], lastNames: Seq[String]) => {
    @tailrec
    lazy val helper: (Seq[String], Seq[String], Vector[Person]) => Seq[Person] =
      (firstNames: Seq[String], lastNames: Seq[String], people: Vector[Person]) => {
        if (firstNames.isEmpty)
          people
        else {
          val newPerson = Person(firstNames.head, lastNames.head)
          helper(firstNames.tail, lastNames.tail, people :+ newPerson)
        }
      }

    helper(firstNames, lastNames, Vector[Person]())
  }*/

  def makePeople(firstNames: Seq[String], lastNames: Seq[String]) = {
    @tailrec
    def helper(firstNames: Seq[String], lastNames: Seq[String],
               people: Vector[Person]): Seq[Person] =
      if (firstNames.isEmpty)
        people
      else {
        val newPerson = Person(firstNames.head, lastNames.head)
        helper(firstNames.tail, lastNames.tail, people :+ newPerson)
      }
    helper(firstNames, lastNames, Vector[Person]())
  }

  def run(): Unit = {
    println("MakePeople :")

    val people = makePeople(Seq("Yourtion1", "Yourtion2"), Seq("Guo1", "Guo2"))
    for(p <- people) yield println(p)

    println()
  }
}
