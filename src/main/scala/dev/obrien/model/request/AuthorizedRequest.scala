package dev.obrien.model.request

import com.twitter.finatra.request.Header

class AuthorizedRequest(@Header val token: Option[String])
