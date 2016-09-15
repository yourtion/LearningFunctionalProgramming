package com.yourtion.PatternDemo

import com.yourtion.Pattern01.{PersonExample, PersonExampleEx}

/**
  * Created by Yourtion on 9/7/16.
  */
object Example extends App {

  override def main(args: Array[String]): Unit = {
    println("PersonExample : \n")
    PersonExample.run()
    println()

    System.out.println("PersonExampleEx : \n")
    PersonExampleEx.run()
  }

}
