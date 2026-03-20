package controllers

import javax.inject.*
import play.api.*
import play.api.mvc.*
import repositories.ProductRepository

import scala.concurrent.*


@Singleton
class ProductController @Inject()(val controllerComponents: ControllerComponents, productRepo: ProductRepository)
                                 (using ec: ExecutionContext) extends BaseController {
  
  
  def list() = Action.async:
    productRepo.findAll().map { products =>
      Ok(views.html.product(products))
    }
    
  def show(id: String) = Action.async:
    productRepo.findById(id).map {
      case Some(product) => Ok(views.html.productDetail(product))
      case None => NotFound("Product not found")  
    }
}

