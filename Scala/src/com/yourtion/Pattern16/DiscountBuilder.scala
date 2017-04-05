package com.yourtion.Pattern16

/**
  * Created by Yourtion on 05/04/2017.
  */
object DiscountBuilder {

  def discount(percent: Double) = {
    if(percent < 0.0 || percent > 100.0)
      throw new IllegalArgumentException("Discounts must be between 0.0 and 100.0.")
    (originalPrice: Double) =>
      originalPrice - (originalPrice * percent * 0.01)
  }

  def run(): Unit = {
    println("DiscountBuilder :")
    println("200 50% discount -> " + discount(50)(200))
    println("200 0% discount -> " + discount(0)(200))
    println("200 100% discount -> " + discount(100)(200))
    val twentyFivePercentOff = discount(25)
    println("Multi1 : " + (Vector(100.0, 25.0, 50.0, 25.0) map twentyFivePercentOff sum))
    println("Multi2 : " + (Vector(75.0, 25.0) map twentyFivePercentOff sum))
  }

}
