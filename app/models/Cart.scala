package models

case class CartItem(productId: String, quantity: Int)
case class Cart(items: List[CartItem])
