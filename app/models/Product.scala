package models

import java.util.UUID

case class Product(
  id: UUID,
  name: String,
  description: String,
  price: BigDecimal,
  imageUrl: String,
  stock: Int
)

