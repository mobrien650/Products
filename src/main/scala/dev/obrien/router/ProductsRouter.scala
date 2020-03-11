package dev.obrien.router

import com.twitter.finagle.http.Request
import dev.obrien.model.request.ProductRequest.GetAllProducts
import dev.obrien.model.request.ProductRequest.SearchProducts
import dev.obrien.model.response.ProductResponse
import dev.obrien.policy.Policy
import dev.obrien.policy.TokenValidatorPolicy
import dev.obrien.repo.ProductRepo
import javax.inject.Singleton

@Singleton
class ProductsRouter extends Router {
  override val policies: Array[Policy] = Array(new TokenValidatorPolicy())

  get("/") { request: Request =>
    "Endpoint is working, awaiting requests..."
  }

  get("/products/all") { request: GetAllProducts =>
    executePolicies(request, response) { () =>
      val products = ProductRepo.getAllProducts
      ProductResponse.fromProducts(products, None)
    }
  }

  get("/products/search") { request: SearchProducts =>
    executePolicies(request, response) { () =>
      val search = request.term
      val products = ProductRepo.searchProducts(search)

      ProductResponse.fromProducts(products, Some(search))
    }
  }
}
