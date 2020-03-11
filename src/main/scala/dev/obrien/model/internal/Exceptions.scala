package dev.obrien.model.internal

object Exceptions {
  final case class PolicyFailure(error: Any) extends Exception
}
