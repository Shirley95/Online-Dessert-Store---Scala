package controllers

import models.{Basket, Item}
import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("saddsa"))
  }

  def home = Action {
    Ok(views.html.home())
  }

  def listings = Action {
    Ok(views.html.listings(Item.aList))
  }

  def description(id: Int) = Action { implicit request:
    Request[AnyContent] =>
    val show = Item.aList.filter(a => a.id == id)
    Ok(views.html.itemDescription(show.head))

  }
}