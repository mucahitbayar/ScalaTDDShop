package com.mucahitbayar.shoppingcart.checkout


import com.mucahitbayar.shoppingcart.domain.{Discount, Product}


case class ShoppingCartItem(product: Product, qty: Int = 1) {
  def total(): BigDecimal = product.price * qty

  def total(discount: Discount): BigDecimal = {
    if (discount.minQty <= qty) {
      val extraQty = qty % discount.minQty
      val quantity = qty - extraQty
      val total = product.price * extraQty + discount.reducedPrice * quantity
      total
    }
    else product.price * qty
  }

  def isSame(other: ShoppingCartItem): Boolean = this.product.isEqual(other.product)

  def add(other: ShoppingCartItem): ShoppingCartItem = {
    if (isSame(other)) {
      ShoppingCartItem(this.product, this.qty + other.qty)
    } else {
      throw new IllegalArgumentException("The Products are note same !")
    }
  }
}