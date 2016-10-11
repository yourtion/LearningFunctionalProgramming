package com.yourtion.PatternDemo

import com.yourtion.Pattern05.{HigherOrderFunctions, TheLambdaBarAndGrille}

/**
  * Created by Yourtion on 9/7/16.
  */
object Example extends App {

  override def main(args: Array[String]): Unit = {
    println("HigherOrderFunctions Example : \n")
    HigherOrderFunctions.run()
    println()

    println("Sequences Comprehension Example : \n")
    TheLambdaBarAndGrille.run()
    
  }

}
