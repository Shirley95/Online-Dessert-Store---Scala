package models

import play.api.data._
import play.api.data.Forms._

import scala.collection.mutable.ArrayBuffer

case class Item(id: Int, image: String, name: String, price: BigDecimal, Stock: Int)

object Item {

  val aList = List(Item(1, "images/cherblocake.jpg","Cherry-Blossom Cheesecake", 14.50, 10),
    Item(2, "images/MolChoc.png", "Molten-Chocolate Cake", 10.00, 5),
    Item(3, "images/matchacake.jpeg", "Matcha Cake", 15.00, 2))

  // .find similar to .filter
  def getItem(id: Int): Option[Item] = {
      val show = Item.aList.filter(a => a.id == id)
      show.headOption
  }

}

