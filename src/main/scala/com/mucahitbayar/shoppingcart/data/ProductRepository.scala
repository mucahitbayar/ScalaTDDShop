package com.mucahitbayar.shoppingcart.data

import com.mucahitbayar.shoppingcart.domain.Product

class ProductRepository extends Repository[Product]{

  override def exists(id: String): Boolean = ProductRepository.prodcuts.contains(id.trim.toLowerCase)

  override def get(id: String): Option[Product] = ProductRepository.prodcuts.get(id.trim.toLowerCase)

  override def getAll(): List[Product] = ProductRepository.prodcutList
}

object ProductRepository {

  private val prodcuts: Map[String,Product] = Map("apple"->Product("Apple", 0.60), "orange"->Product("Orange", 0.25))
  private lazy val prodcutList: List[Product] = prodcuts.map(_._2).toList

  def apply: ProductRepository = new ProductRepository()
}
