package com.yourtion.Pattern18

import scala.util.Random

/**
  * Created by Yourtion on 06/04/2017.
  */
object LazySequenceExample {

  val integers = Stream.from(0)

  val generate = new Random()
  val randoms = Stream.continually(generate.nextInt)

  def pagedSequence(pageNum: Int): Stream[String] =
    getPage(pageNum) match {
      case Some(page: String) => page #:: pagedSequence(pageNum + 1)
      case None => Stream.Empty
    }

  def getPage(page: Int) =
    page match {
      case 1 => Some("Page1")
      case 2 => Some("Page2")
      case 3 => Some("Page3")
      case _ => None
    }

  def run(): Unit = {
    println("Some Ints :")
    val someints = integers take 5
    someints foreach println
    println()

    println("aFewRabdom :")
    val aFewRabdom = randoms take 5
    aFewRabdom foreach println
    println()

    println("aFewMoreRabdom :")
    val aFewMoreRabdom = randoms take 6
    aFewMoreRabdom foreach println
    println()

    println("print Hello :")
    val printHellos = Stream.continually(println("hello"))
    println(printHellos take 5 )
    println()
    println(printHellos take 5 force)
    println()

    println("aStream head :")
    val aStream = "foo" #:: "bar" #:: Stream[String]()
    println("Head:" + aStream.head)
    println("Tail: " + aStream.tail)
    println()

    println("pages :")
    println(pagedSequence(1) take 2 force)
    println(pagedSequence(1) force)
    println()

    val holdsHead = {
      def pagedSequence(pageNum: Int): Stream[String] =
        getPage(pageNum) match {
          case Some(page: String) => {
            println("Realizing " + page)
            page #:: pagedSequence(pageNum + 1)
          }
          case None => Stream.Empty
        }
      pagedSequence(1)
    }

    println("holdsHead :")
    println(holdsHead force)
    println()

    def doesntHoldHead = {
      def pagedSequence(pageNum: Int): Stream[String] =
        getPage(pageNum) match {
          case Some(page: String) => {
            println("Realizing " + page)
            page #:: pagedSequence(pageNum + 1)
          }
          case None => Stream.Empty
        }
      pagedSequence(1)
    }
    println("doesntHoldHead :")
    println(doesntHoldHead force)
    println()
  }
}
