package com.mucahitbayar.shoppingcart

import com.mucahitbayar.shoppingcart.checkout.{ShoppingCart, ShoppingCartItem}
import com.mucahitbayar.shoppingcart.data.{DiscountRepository, ProductRepository, Repository}
import com.mucahitbayar.shoppingcart.domain.{Discount, Product}

object CheckOut {
  def main(args: Array[String]): Unit = {
    val productRepository = new ProductRepository()
    val discounts: List[Discount] = getDiscounts
    val shoppingCart = addToShoppingCart(productRepository, discounts, args)
    shoppingCart.printTotal
  }

  def getDiscounts = {
    val discountRepository = new DiscountRepository()
    val discounts: List[Discount] = discountRepository.getAll()
    discounts
  }

  def addToShoppingCart(productRepository: Repository[Product], discounts: List[Discount], items: Array[String]): ShoppingCart = {
    val products = mapToProducts(productRepository, items)
    val shoppingCartItems = products.map(p => (p, 1)).groupBy(_._1).map(m => ShoppingCartItem(m._1, m._2.size)).toList
    ShoppingCart(shoppingCartItems, discounts)
  }

  def mapToProducts(repository: Repository[Product], args: Array[String]): List[Product] = {
    args.map(arg => repository.get(arg)).flatMap(p => p).toList
  }

}
