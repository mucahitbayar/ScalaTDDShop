package com.mucahitbayar.shoppingcart.checkout

import com.mucahitbayar.shoppingcart.domain.Product
import org.scalatest.FlatSpec

class ShoppingCartTest extends FlatSpec {

  behavior of "formatPrice"
  it should "format price bigger than 1 to pounds (£)" in{
    val expected = "£3.05"
    val actual = ShoppingCart.formatPrice(3.05)
    expected === actual
  }
  it should "format price smaller than 1 to penny/pence (p)" in{
    val expected = "£0.99"
    val actual = ShoppingCart.formatPrice(0.99)
    expected === actual
  }


  "formatTotal" should "format products and total to display" in {
    val shoppingCartItems =List(ShoppingCartItem(Product("Apple",0.6),3),ShoppingCartItem(Product("Orange", 0.25),1))
    val expected = "[Apple (3),Orange (1)] => £1.15"
    val actual = ShoppingCart.formatTotal(shoppingCartItems,"£1.15")
    expected === actual
  }

}
