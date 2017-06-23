package com.mucahitbayar.shoppingcart


import com.mucahitbayar.shoppingcart.domain.Product
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

class CheckOutTest extends FlatSpec with MockFactory {

  val apple = Product("Apple", 0.60)
  val orange = Product("Orange", 0.25)

  "mapToProducts" should " find all products and return existing Products" in {
    val repositoryStub = stub[com.mucahitbayar.shoppingcart.data.Repository[Product]]
    (repositoryStub.get _).when("Apple").returns(Some(apple))
    (repositoryStub.get _).when("Orange").returns(Some(orange))

    val items = Array("Apple", "Apple", "Orange", "Apple")
    val expected = List(apple, apple, orange, apple)
    val actual = CheckOut.mapToProducts(repositoryStub, items)
    actual == expected
  }

  "addToShoppingCart" should "return shopping cart" in {
    val items = Array("Apple", "Apple", "Orange", "Apple")
    CheckOut.main(items)
  }

}
