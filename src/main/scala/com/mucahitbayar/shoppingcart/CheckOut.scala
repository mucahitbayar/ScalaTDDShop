package com.mucahitbayar.shoppingcart

import com.mucahitbayar.shoppingcart.domain.Product

object CheckOut {
  val products:Set[Product]=Set(Product("Apple", 0.60),Product("Orange", 0.25))
  def main(args: Array[String]): Unit = {
    val items: List[Product] = getProducts(args)
    val formattedPrice: String = formatPrice(items)
    val totalString: String = getTotalToDisplay(items, formattedPrice)
    println(totalString)
  }

   def getTotalToDisplay(items: List[Product], formattedPrice: String) = {
    val totalString = s"[ ${items.map(p => p.name).mkString(", ")} ] => ${formattedPrice}"
    totalString
  }

  def getProducts(args: Array[String]) = {
    val items = args.flatMap(s => products.find(p => p.isEqual(s))).toList
    items
  }

   def formatPrice(items: List[Product]) = {
    val totalPrice = items.map(p => p.price).sum
    val totalString = if (totalPrice > 1) s"£${totalPrice}" else s"${totalPrice * 100}p"
    totalString
  }
}
