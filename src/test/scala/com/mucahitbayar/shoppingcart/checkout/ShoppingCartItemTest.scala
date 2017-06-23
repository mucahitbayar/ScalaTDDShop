package com.mucahitbayar.shoppingcart.checkout


import com.mucahitbayar.shoppingcart.domain.Product
import org.scalatest.{BeforeAndAfter, FlatSpec}

class ShoppingCartItemTest extends FlatSpec  with BeforeAndAfter {

  it should "return new instance  with 1 quantity and product price " +
    "when quantity and sellingPrice is not provided" in {
    val product=Product("Apple",0.60)
    val shoppingCartItem=ShoppingCartItem(product)
    shoppingCartItem.product === product
    shoppingCartItem.qty === 1
  }

  it should "return new instance  with specified quantity and selling price " +
    "when quantity and sellingPrice is  provided" in {
    val product=Product("Apple",0.60)
    val qty:Int=5
    val shoppingCartItem=ShoppingCartItem(product,qty)
    shoppingCartItem.product === product
    shoppingCartItem.qty === qty
  }

}
