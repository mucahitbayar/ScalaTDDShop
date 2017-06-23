package com.mucahitbayar.shoppingcart.domain

case class Product(name:String,price:BigDecimal) {
  def isEqual(other:Product):Boolean=this.name.toLowerCase==other.name.toLowerCase
  def isEqual(productName:String):Boolean=this.name.toLowerCase==productName.toLowerCase
}
