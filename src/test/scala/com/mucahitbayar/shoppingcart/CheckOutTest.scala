package com.mucahitbayar.shoppingcart

import com.mucahitbayar.shoppingcart.domain.Product
import org.scalatest.FlatSpec

class CheckOutTest extends FlatSpec {

  val apple = Product("Apple", 0.60)
  val orange = Product("Orange", 0.25)


  behavior of "products"

  it should "have only 1 apple" in {
    CheckOut.products.count(p => p.isEqual(apple)) === 1
  }

  it should "have only 1 orange" in {
    CheckOut.products.count(p => p.isEqual(orange)) === 1
  }


  behavior of "getProducts"

  it should "return existing products" in {
    val args = Array("Apple", "Orange")
    val items = CheckOut.getProducts(args)
    items.forall(p => CheckOut.products.exists(c => c.isEqual(p)))
  }

  "getTotalToDisplay" should "print products" in {
    val args = Array("Apple", "Orange")
    val expected = "[ Apple, Apple, Orange, Apple ] => £2.05"
    val actual = CheckOut.getProducts(args)
    expected === actual
  }

}
