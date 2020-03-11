package dev.obrien

import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter
import dev.obrien.router.ProductsRouter

class ProductServer extends HttpServer {
  override val defaultHttpsPort: String = s":${Constants.PORT}"

  override protected def configureHttp(router: HttpRouter): Unit = {
    router
      .filter[CommonFilters]
      .add[ProductsRouter]
  }
}

