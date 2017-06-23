package com.mucahitbayar.shoppingcart.data

import com.mucahitbayar.shoppingcart.domain.{Discount, Product}


class DiscountRepository extends Repository[Discount] {

  override def exists(id: String): Boolean = DiscountRepository.discounts.contains(id.trim.toLowerCase)

  override def get(id: String): Option[Discount] = DiscountRepository.discounts.get(id.trim.toLowerCase)

  override def getAll(): List[Discount] = DiscountRepository.discountList
}

object DiscountRepository {

  private val discounts: Map[String, Discount] =
    Map("apple" -> Discount(Product("Apple", 0.60), 1, 0.50), "orange" -> Discount(Product("Orange", 0.25), 3, 2 / 3))
  private lazy val discountList: List[Discount] = discounts.map(_._2).toList

  def apply: ProductRepository = new ProductRepository()
}
