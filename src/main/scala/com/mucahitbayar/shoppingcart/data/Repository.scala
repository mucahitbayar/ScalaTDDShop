package com.mucahitbayar.shoppingcart.data

trait Repository[T]{
  def exists(id:String):Boolean
  def get(id:String):Option[T]
  def getAll():List[T]
}
