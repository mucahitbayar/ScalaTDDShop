package com.mucahitbayar.shoppingcart

import com.mucahitbayar.shoppingcart.data.ProductRepository
import com.mucahitbayar.shoppingcart.domain.Product

object CheckOut {
  def main(args: Array[String]): Unit = {
    val items: List[Product] = getProducts(args)
    val totalPrice: BigDecimal = calculateTotalPrice(items)
    val formattedPrice: String = formatPrice(totalPrice)
    val totalString: String = getTotalToDisplay(items, formattedPrice)
    println(totalString)
  }

  def getProducts(args: Array[String]): List[Product] = {
    val productRepository = new ProductRepository()
    val items = args.flatMap(s => productRepository.get(s)).toList
    items
  }

  def calculateTotalPrice(items: List[Product]) = {
    val totalPrice = items.map(p => p.price).sum
    totalPrice
  }

  def formatPrice(totalPrice: BigDecimal) = {
    if (totalPrice > 1) s"£${totalPrice}" else s"${totalPrice * 100}p"
  }

  def getTotalToDisplay(items: List[Product], formattedPrice: String) = {
    val totalString = s"[ ${items.map(p => p.name).mkString(", ")} ] => ${formattedPrice}"
    totalString
  }

}
