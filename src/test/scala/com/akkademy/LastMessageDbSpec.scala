package com.akkademy

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import com.akkademy.messages.SetRequest
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}

class LastMessageDbSpec extends FunSpecLike with Matchers with BeforeAndAfterEach {
  implicit val system = ActorSystem()
  describe("lastMessageDb") {
    it("should receive a message correctly") {
      val actorRef = TestActorRef(new LastMessageDb)
      actorRef ! SetRequest("key", "value")
      val akkademyDb = actorRef.underlyingActor
      akkademyDb.map.get("key") should equal(Some("value"))
    }

    it("should store only the last of the two messages") {
      val actorRef = TestActorRef(new LastMessageDb)
      actorRef ! SetRequest("key1", "value1")
      actorRef ! SetRequest("key2", "value2")
      val akkademyDb = actorRef.underlyingActor
      akkademyDb.map.get("key1") should equal(None)
      akkademyDb.map.get("key2") should equal(Some("value2"))
    }
  }
}
