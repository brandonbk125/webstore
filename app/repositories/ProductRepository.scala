package repositories

import models.Product

import scala.concurrent.{ExecutionContext, Future}
import scala.jdk.CollectionConverters.*
import com.mongodb.client.{MongoClient, MongoClients}
import org.bson.Document
import org.bson.types.ObjectId
import javax.inject.*
import play.api.Configuration


@Singleton
class ProductRepository @Inject()(config: Configuration) {

  private val db: String = config.get("mongodb.database")
  private val col: String = config.get("mongodb.collection")
  private val mongoUri = sys.env.getOrElse("MONGODB_URI", sys.error("MONGODB URI NOT FOUND"))

  private val client: MongoClient = MongoClients.create(mongoUri)
  private val collection = client.getDatabase(db).getCollection(col)

  private def toProduct(doc: Document): Option[Product] = {
     Option(Product (
      id = doc.getObjectId("_id").toHexString,
      name = doc.getString("name"),
      price = BigDecimal(doc.get("price").toString),
      description = doc.getString("description"),
      imageUrl = doc.getString("imageUrl"),
      stock = doc.get("stock").toString.toInt
    ))
  }

  def findAll(): Future[Seq[Product]] = {
    Future.successful(collection.find().iterator().asScala.flatMap(toProduct).toSeq)
  }

  def findById(id: String): Future[Option[Product]] =
    val doc: Document = collection.find(new Document("_id", ObjectId(id))).first
    Future.successful(toProduct(doc))



}
