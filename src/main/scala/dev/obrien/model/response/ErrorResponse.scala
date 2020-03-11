package dev.obrien.model.response

import com.twitter.finagle.http.Response

case class ErrorResponse(val error: Any)
