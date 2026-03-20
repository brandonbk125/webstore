package models

import java.util.UUID

case class Product(
  id: String,
  name: String,
  description: String,
  price: BigDecimal,
  imageUrl: String,
  stock: Int
)

