package dev.obrien.model.response

import dev.obrien.model.internal.Product

case class ProductResponse(products: Array[Product], searchTerm: Option[String])

object ProductResponse {
  def fromProducts(products: Array[Product], term: Option[String]): ProductResponse = {
    ProductResponse(products, term)
  }
}
