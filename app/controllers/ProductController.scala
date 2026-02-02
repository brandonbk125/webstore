package controllers

import javax.inject.*
import play.api.*
import play.api.mvc.*
import repositories.ProductRepository

import java.util.UUID
import scala.concurrent.*


@Singleton
class ProductController @Inject()(val controllerComponents: ControllerComponents, productRepo: ProductRepository)
                                 (using ec: ExecutionContext) extends BaseController {
  
  
  def list() = Action.async:
    productRepo.findAll().map { products =>
      Ok(views.html.admin(products))
      
    }
    
  def show(id: String) = Action.async:
    val uuid = UUID.fromString(id)
    
    productRepo.findById(uuid).map {
      case Some(product) => Ok(views.html.product(product))
      case None => NotFound("Product not found")  
    }
}

