package dev.obrien.policy

import dev.obrien.Constants
import dev.obrien.model.request.AuthorizedRequest
import scala.concurrent.ExecutionContext

class TokenValidatorPolicy extends Policy {
  implicit val ec: ExecutionContext = ExecutionContext.Implicits.global

  override def process(request: AuthorizedRequest, onSuccess: () => Unit, onFailure: (Any) => Unit): Unit = {
    if(request.token.getOrElse("") == Constants.TOKEN) {
      onSuccess()
    } else {
      onFailure("Token was invalid")
    }
  }
}

