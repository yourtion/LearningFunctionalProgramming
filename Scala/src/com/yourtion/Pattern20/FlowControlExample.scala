package com.yourtion.Pattern20

/**
  * Created by Yourtion on 07/04/2017.
  */
object FlowControlExample {
  def choose[E](num: Int, first: () => E, second: () => E, third: () => E) =
    if (num == 1) first()
    else if (num == 2) second()
    else if (num == 3) third()

  def test[E](expression: E) = expression

  def testTwice[E](expression: E) = {
    expression
    expression
  }

  def printTwice[E](expression: E) {
    println(expression)
    println(expression)
  }

  def testByName[E](expression: => E) = {
    expression
    expression
  }

  def simplerChoose[E](num: Int, first: => E, second: => E, third: => E) =
    if (num == 1) first
    else if (num == 2) second
    else if (num == 3) third

  def timeRun[E](toTime: => E) = {
    val start = System.currentTimeMillis
    toTime
    System.currentTimeMillis - start
  }
  def avgTime[E](times: Int, toTime: => E) = {
    val allTimes = for (_ <- Range(0, times)) yield timeRun(toTime)
    allTimes.sum / times
  }

  def run(): Unit = {
    println("choose :")
    choose(2, () => println("hello, world"), () => println("goodbye, cruel world"), () => println("meh, indifferent world"))
    println("test :")
    test(println("hello, world"))
    println("testTwice :")
    testTwice(println("hello, world"))
    println("printTwice :")
    printTwice(5 * 5)
    println("testByName :")
    testByName(println("hello, world"))
    println("simplerChoose :")
    simplerChoose(2, println("hello, world"), println("goodbye, cruel world"), println("meh, indifferent world"))
    println()

    println("avgTime : ")
    println(avgTime(5, Thread.sleep(1000)))
  }
}
