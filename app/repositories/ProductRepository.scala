package repositories

import models.Product
import java.util.UUID
import scala.concurrent.{ExecutionContext, Future}

class ProductRepository {
  
  private val products = Seq(
    Product(
      UUID.randomUUID(),
      "Macbook Pro",
      "Apple laptop",
      BigDecimal(1999.99),
      "assets/images/macbook.jpg",
      5
    ),
    Product(
      UUID.randomUUID(),
      "Mechanical Keyboard",
      "RGB Keyboard",
      BigDecimal(149.99),
      "assets/images/keyboard.jpg",
      10
    )
  )
  
  def findAll(): Future[Seq[Product]] =
    Future.successful(products)
    
  def findById(id: UUID): Future[Option[Product]] =
    Future.successful(products.find(_.id == id))

}
