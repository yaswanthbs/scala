package com.digitalmercator.service

import com.digitalmercator.model.Product

class Checkout {

  private var products: List[Product] = List()

  def scan(product: Product): Unit = {
    products = product :: products
  }

  def total: Double = {
    products.map(_.price).sum
  }

  def clear(): Unit = {
    products = List()
  }

}
