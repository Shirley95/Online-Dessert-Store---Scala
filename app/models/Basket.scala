package models

import scala.collection.mutable.ArrayBuffer

object Basket {
  var shoppingList = ArrayBuffer[Int]()

  def add(id: Int): Unit = {
    shoppingList.append(id)
  }

  def delete(id: Int): Unit = {
    shoppingList -= id
  }

}
