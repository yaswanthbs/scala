package com.digitalmercator.service

import com.digitalmercator.model.Product

class Checkout {

  private var products: List[Product] = List()

  def scan(product: Product): Unit = {
    products = product :: products
  }

  def total: Double = {
    val groupedItems = products.groupBy(_.name).mapValues(_.size)

    val appleCount = groupedItems.get("Apple").getOrElse(0)
    val orangeCount = groupedItems.get("Orange").getOrElse(0)

    val appleTotal = (appleCount / 2) * 0.60 + (appleCount % 2) * 0.60 // BOGOF offer on apples
    val orangeTotal = (orangeCount / 3) * 2 * 0.25 + (orangeCount % 3) * 0.25 // 3 for 2 on oranges

    appleTotal + orangeTotal
  }

  def clear(): Unit = {
    products = List()
  }

}
