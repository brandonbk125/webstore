package models

import java.time.Instant
import java.util.UUID

case class Order(
                  id: UUID,
                  userId: UUID,
                  items: List[CartItem],
                  total: BigDecimal,
                  status: String,
                  createdAt: Instant
                )
