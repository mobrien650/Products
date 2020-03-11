package dev.obrien.model.request

import com.twitter.finatra.request.Header
import com.twitter.finatra.request.QueryParam

object ProductRequest {

  case class GetAllProducts(@Header override val token: Option[String]) extends AuthorizedRequest(token)

  case class SearchProducts(@Header override val token: Option[String], @QueryParam term: String) extends AuthorizedRequest(token)

}
