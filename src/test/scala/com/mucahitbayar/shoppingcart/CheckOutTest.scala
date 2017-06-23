package com.mucahitbayar.shoppingcart

import com.mucahitbayar.shoppingcart.domain.Product
import org.scalatest.FlatSpec

class CheckOutTest extends FlatSpec {

  val apple = Product("Apple", 0.60)
  val orange = Product("Orange", 0.25)

  behavior of "getProducts"

  it should "return existing products" in {
    val args = Array("Apple", "Orange")
    val expected=List(apple,orange)
    val actual = CheckOut.getProducts(args)
    expected === actual
  }

  behavior of "formatPrice"
  it should "format price bigger than 1 to pounds (£)" in{
    val expected = "£3.05"
    val actual = CheckOut.formatPrice(3.05)
    expected === actual
  }
  it should "format price smaller than 1 to penny/pence (p)" in{
    val expected = "£0.99"
    val actual = CheckOut.formatPrice(0.99)
    expected === actual
  }

  "getTotalToDisplay" should "print products" in {
    val args = Array("Apple", "Apple", "Orange", "Apple")
    val expected = "[ Apple, Apple, Orange, Apple ] => £2.05"
    val actual = CheckOut.getProducts(args)
    expected === actual
  }

}
