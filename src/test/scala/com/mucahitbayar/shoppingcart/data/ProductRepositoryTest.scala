package com.mucahitbayar.shoppingcart.data

import com.mucahitbayar.shoppingcart.domain.Product
import org.scalatest.{BeforeAndAfter, FlatSpec}

class ProductRepositoryTest extends FlatSpec  with BeforeAndAfter {

  val apple = Product("Apple", 0.60)
  val orange = Product("Orange", 0.25)
  var repository: Repository[Product] = _

  before {
    repository = new ProductRepository()
  }

  behavior of "get"

  it should "return apple when request apple" in {
    repository.get("Apple") === apple
  }

  it should "return orange when request orange" in {
    repository.get("Apple") === apple
  }

  it should "not return anything when request non existing item" in {
    repository.get("Item").isEmpty
  }

  behavior of "getAll"

  it should "return list of products with apple and orange" in {
    repository.getAll === List(apple, orange)
  }

}
