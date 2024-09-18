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

    checkout.total shouldEqual 2.05
  }
}
