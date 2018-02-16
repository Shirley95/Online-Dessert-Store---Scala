package controllers

import javax.inject.Inject

import models.{Basket, Item}
//import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc.{Action, Controller}

import scala.collection.mutable.ArrayBuffer

class BasketController @Inject() extends Controller{


  // grab ids and convert to items and display
  def basketList = Action { implicit request =>
    val stuff = models.Basket.shoppingList
    val items = ArrayBuffer[Option[Item]]()

    for (i <- stuff)
      items.append(Item.getItem(i))

    var price:BigDecimal = 0
    items.foreach(x => price += x.get.price)

    Ok(views.html.basket(items.flatten)(price))
  }

  // add items to basket, redirect calls the basket-list method and anything else happens is in that method
  def addToBasket(id: Int) = Action {implicit request =>
    models.Basket.add(id)
    Redirect(routes.BasketController.basketList())
  }

  def removeItem(id: Int) = Action {implicit request =>
    models.Basket.delete(id)
    Redirect(routes.BasketController.basketList())
  }

  def checkout = Action { implicit request =>
    Ok(views.html.checkout())
  }
}
