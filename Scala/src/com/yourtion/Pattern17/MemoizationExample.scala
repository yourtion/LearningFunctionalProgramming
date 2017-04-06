package com.yourtion.Pattern17

/**
  * Created by Yourtion on 06/04/2017.
  */
object MemoizationExample {

  def expensiveLookup(id: Int) = {
    Thread.sleep(1000)
    println(s"Doing expensive lookup for $id")
    Map(42 -> "foo",  12 -> "bar",  1 -> "baz").get(id)
  }

  def memoizeExpensiveLookup() = {
    var cache = Map[Int, Option[String]]()
    (id: Int) =>
      cache.get(id) match {
        case Some(result: Option[String]) => result
        case None => {
          val result = expensiveLookup(id)
          cache += id -> result
          result
        }
      }
  }


  def run(): Unit = {
    println("Expensive lookup :")
    println("One: " + expensiveLookup(42))
    println("Two: " + expensiveLookup(42))

    println("Memoize lookup :")
    val memoizedExpensiveLookup = memoizeExpensiveLookup
    println("One: " + memoizedExpensiveLookup(42))
    println("Two: " + memoizedExpensiveLookup(42))
  }

}
