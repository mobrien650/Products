package dev.obrien.router

import com.twitter.finatra.http.Controller
import com.twitter.finatra.http.response.ResponseBuilder
import dev.obrien.model.internal.Exceptions
import dev.obrien.model.request.AuthorizedRequest
import dev.obrien.model.response.ErrorResponse
import dev.obrien.policy.Policy
import scala.concurrent.ExecutionContext

class Router extends Controller {
  protected implicit val ec: ExecutionContext = ExecutionContext.Implicits.global

  protected val policies: Array[Policy] = Array()

  def executePolicies(request: AuthorizedRequest, response: ResponseBuilder)(callback: () => Any): Any = {
    try {
      next(0, request)()
      callback()
    } catch {
      case e: Exceptions.PolicyFailure => { response.forbidden(ErrorResponse(e.error)) }
    }
  }

  private def error(error: Any): Unit = {
    throw Exceptions.PolicyFailure(error)
  }

  private def next(index : Int, request: AuthorizedRequest): () => Unit = {
    { () =>
      if(index < policies.length) {
        val policy = policies(index)
        val nextFunc = next(index + 1, request)
        policy.process(request, nextFunc, error)
      }
    }
  }
}
