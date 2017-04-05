package com.yourtion.Pattern16

import scala.annotation.tailrec
import scala.collection.immutable.Map

/**
  * Created by Yourtion on 05/04/2017.
  */
object SelectorExample {

  def selector(path: Symbol*): (Map[Symbol, Any] => Option[Any]) = {

    if(path.size <= 0) throw new IllegalArgumentException("path must not be empty")

    @tailrec
    def selectorHelper(path: Seq[Symbol], ds: Map[Symbol, Any]): Option[Any] =
      if(path.size == 1) {
        ds.get(path(0))
      }else{
        val currentPiece = ds.get(path.head)
        currentPiece match {
          case Some(currentMap: Map[Symbol, Any]) =>
            selectorHelper(path.tail, currentMap)
          case None => None
          case _ => None
        }
      }

    (ds: Map[Symbol, Any]) => selectorHelper(path.toSeq, ds)
  }

  def run(): Unit = {
    println("SelectorExample :")
    val simplePerspon = Map('name -> "Yourtion Guo")
    val name = selector('name)
    println("name from simplePerson: " + name(simplePerspon))
    val moreComplexPerson = Map('name -> Map('First -> "Yourtion", 'last -> "Guo"))
    val firstName = selector('name, 'first)
    println("firstName from moreComplexPerson: " + firstName(moreComplexPerson))
    val middleName = selector('name, 'middle)
    println("middleName from moreComplexPerson: " + middleName(moreComplexPerson))
  }

}
