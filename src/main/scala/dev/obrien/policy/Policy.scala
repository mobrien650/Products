package dev.obrien.policy

import dev.obrien.model.request.AuthorizedRequest

trait Policy {
  def process(request: AuthorizedRequest, onSuccess: () => Unit, onFailure: (Any) => Unit): Unit
}
