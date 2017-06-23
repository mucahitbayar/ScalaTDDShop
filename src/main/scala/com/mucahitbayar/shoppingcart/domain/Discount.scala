package com.mucahitbayar.shoppingcart.domain

case class Discount(product:Product,minQty:Int,ratio:Double) {
  val discountAmount:BigDecimal=product.price * ratio
  val reducedPrice:BigDecimal=product.price - discountAmount
}

