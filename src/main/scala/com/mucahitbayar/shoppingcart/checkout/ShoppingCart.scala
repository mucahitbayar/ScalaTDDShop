package com.mucahitbayar.shoppingcart.checkout

import com.mucahitbayar.shoppingcart.domain.{Discount, Product}

case class ShoppingCart(items: List[ShoppingCartItem], discounts: List[Discount]) {

  def add(shoppingCartItem: ShoppingCartItem): ShoppingCart = {
    val result = this.items.find(si => si.isSame(shoppingCartItem))
    result match {
      case Some(item) => ShoppingCart(item.add(shoppingCartItem) :: items, discounts)
      case _ => ShoppingCart(shoppingCartItem :: items, discounts)
    }
  }

  def add(shoppingCartItems: List[ShoppingCartItem]): ShoppingCart = {
    if (shoppingCartItems.isEmpty) this
    else {
      add(shoppingCartItems.head).add(shoppingCartItems.tail)
    }
  }

  def add(product: Product, qty: Int = 1): ShoppingCart = {
    val shoppingCartItem = ShoppingCartItem(product, qty)
    add(shoppingCartItem)
  }

  val total: BigDecimal = ShoppingCart.calculateTotalPrice(items, discounts)
  val formatPrice: String = ShoppingCart.formatPrice(total)

  def printTotal = {
    println(ShoppingCart.formatTotal(items,formatPrice))
  }

}

object ShoppingCart {

  def formatPrice(totalPrice: BigDecimal): String = {
    if (totalPrice > 1) s"£${totalPrice}" else s"${totalPrice * 100}p"
  }

  def calculateTotalPrice(items: List[ShoppingCartItem], discounts: List[Discount]): BigDecimal = {
    if (discounts.isEmpty) items.map(p => p.total).sum
    else {
      items.map { item =>
        val result = discounts.find(d => d.product.isEqual(item.product))
        result match {
          case Some(discount) => item.total(discount)
          case _ => item.total()
        }
      }.sum
    }
  }

  def formatTotal(items: List[ShoppingCartItem], formatPrice: String) = {
    s"[${items.map(p => p.product.name + " (" + p.qty + ")").mkString(",")}] => ${formatPrice}"
  }

}
