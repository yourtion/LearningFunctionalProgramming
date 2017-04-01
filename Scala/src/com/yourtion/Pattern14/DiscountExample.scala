package com.yourtion.Pattern14

/**
  * Created by Yourtion on 01/04/2017.
  */
object DiscountExample {
  def calculateDiscount(prices : Seq[Double]) : Double = {
    prices filter(price => price >= 20.0) map
      (price => price * 0.10) reduce
      ((total, price) => total + price)
  }

  def calculateDiscountNamedFn(prices : Seq[Double]) : Double = {
    def isGreaterThan20(price : Double) = price >= 20.0
    def tenPercent(price : Double) = price * 0.10
    def sumPrices(total: Double, price : Double) = total + price

    prices filter isGreaterThan20 map tenPercent reduce sumPrices
  }

  def run(): Unit = {
    println("Discount :")

    println("calculateDiscount : " + calculateDiscount(Vector(20.0, 4.5, 50.0, 15.75, 30.0, 3.5)))
    println("calculateDiscountNamedFn : " +calculateDiscountNamedFn(Vector(20.0, 4.5, 50.0, 15.75, 30.0, 3.5)))
  }
}
