package dev.obrien.repo

import dev.obrien.model.internal.Product

object ProductRepo {
  private val products = ProductRepoHelper.products

  def getAllProducts: Array[Product] = {
    products
  }

  def searchProducts(term: String): Array[Product] = {
    products.filter(product => product.name.toLowerCase().contains(term.toLowerCase()) || product.description.toLowerCase().contains(term.toLowerCase))
  }
}

object ProductRepoHelper {
  val products = Array[Product] (
    Product("Soap", "Some really tasty soap! Swear away.", 9.99, 8.99, ""),
    Product("Sponge", "So soft and absorbent, you won't want to put it down.", 14.89, 14.89, ""),
    Product("All Purpose Cleaner", "All Purpose means everything, counters, pets, even your own hair!", 21.19, 20.01, ""),
    Product("Wood Cleaner", "Nearly as good as our All Purpose Cleaner, but only for wood!", 14.19, 10.04, ""),
    Product("Scrub Brush", "Get a good workout in with this state of the art scrub brush", 14.19, 10.04, ""),
    Product("Plunger", "Its a hat! Its a sword! Its already been used.... EW!", 15.50, 12.77, ""),
    Product("Rags", "Its a hat! Its a sword! Its already been used.... EW!", 25.19, 14.04, ""),
    Product("Sink", "A whole sink for your house, but we don't install", 169.99, 150.99, ""),
  )
}
