package com.digitalmercator.service

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.digitalmercator.model.Product

class CheckoutTest extends AnyFlatSpec with Matchers {

  "A Checkout" should "calculate the total cost correctly" in {
    val checkout = new Checkout

    checkout.scan(Product("Apple", 0.60))
    checkout.scan(Product("Orange", 0.25))

    checkout.total shouldEqual 0.85
  }

  it should "handle an empty cart" in {
    val checkout = new Checkout

    checkout.total shouldEqual 0.0
  }

  it should "calculate total with different items" in {
    val checkout = new Checkout

    checkout.scan(Product("Apple", 0.60))
    checkout.scan(Product("Apple", 0.60))
    checkout.scan(Product("Orange", 0.25))
    checkout.scan(Product("Apple", 0.60))

    checkout.total shouldEqual 1.45
  }

  "A Checkout" should "apply BOGOF on apples correctly" in {
    val checkout = new Checkout

    checkout.scan(Product("Apple", 0.60))
    checkout.scan(Product("Apple", 0.60))
    checkout.total shouldEqual 0.60 // Buy 1 get 1 free
  }

  it should "apply 3 for 2 offer on oranges correctly" in {
    val checkout = new Checkout

    checkout.scan(Product("Orange", 0.25))
    checkout.scan(Product("Orange", 0.25))
    checkout.scan(Product("Orange", 0.25))
    checkout.total shouldEqual 0.50 // 3 for the price of 2
  }

  it should "combine both offers correctly" in {
    val checkout = new Checkout

    checkout.scan(Product("Apple", 0.60))
    checkout.scan(Product("Apple", 0.60)) // 1 apple paid for
    checkout.scan(Product("Orange", 0.25))
    checkout.scan(Product("Orange", 0.25))
    checkout.scan(Product("Orange", 0.25)) // 3 oranges total

    checkout.total shouldEqual 1.10 // 0.60 (apples) + 1.50 (oranges)
  }

}
