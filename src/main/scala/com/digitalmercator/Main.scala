package com.digitalmercator

import com.digitalmercator.model.Product
import com.digitalmercator.service.Checkout

object Main {
  val checkout = new Checkout

  checkout.scan(Product("Apple", 0.60))
  checkout.scan(Product("Orange", 0.75))

  println(s"Total Cost: ${checkout.total}") // Output: Total Cost: 1.85

  checkout.clear()

}
