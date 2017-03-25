package com.akkademy

import akka.actor.Actor
import akka.event.Logging
import com.akkademy.messages.SetRequest

import scala.collection.mutable

class LastMessageDb extends Actor {
  val map = new mutable.HashMap[String, Object]()
  val log = Logging(context.system, this)

  override def receive: PartialFunction[Any, Unit] = {
    case SetRequest(key, value) =>
      log.info(s"received SetRequest - key: {$key} value: {$value}")
      map.clear()
      map.put(key, value)
    case o => log.info(s"received unknown message:{$o}")
  }
}