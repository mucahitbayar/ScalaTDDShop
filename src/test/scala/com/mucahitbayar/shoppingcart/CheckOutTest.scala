package com.mucahitbayar.shoppingcart

import org.scalatest.FlatSpec

class CheckOutTest extends FlatSpec  {

  val apple = "Apple"
  val orange = "Orange"


  behavior of "products"

  it should "have only 1 apple" in {
    CheckOut.products.count(p=>p==apple) ===1
  }

  it should "have only 1 orange" in {
    CheckOut.products.count(p=>p==orange) === 1
  }

}
