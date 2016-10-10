package com.yourtion.Pattern03

import com.yourtion.Pattern03

/**
  * Created by Yourtion on 10/10/2016.
  */
object RegisterClient {

  def run() = {
    val register = new CashRegister(0)

    val purchaseOne = Register.makePurchase(register, 100)
    val purchaseTwo = Register.makePurchase(register, 50)

    Register.executePurchase(purchaseOne)
    Register.executePurchase(purchaseTwo)

    println("After purchases: " + register.total)

    println("Register reset to 0")
    register.total = 0

    for (purchase <- Register.purchases) {
      purchase.apply()
    }

    println("After replay: " + register.total)

  }
}
