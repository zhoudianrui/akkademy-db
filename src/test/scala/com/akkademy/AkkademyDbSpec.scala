package com.akkademy

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import akka.util.Timeout
import com.akkademy.messages.Models.SetRequest
import org.scalatest.{FunSpecLike, Matchers}

import scala.concurrent.duration._

/**
  * Description: 测试用例
  * Author: dick
  * Time: 2018/10/26 下午5:04
  */
class AkkademyDbSpec extends FunSpecLike with Matchers{

  implicit val system = ActorSystem()
  implicit val timeout = Timeout(5 seconds)

  describe("akkademy") {
    describe("given SetRequest") {
      it("should place key/value into map") {
        val actorRef = TestActorRef(new AkkademyDb)
        actorRef ! SetRequest("key", "value")

        val akkademyDb = actorRef.underlyingActor
        akkademyDb.map.get("key") should equal(Some("value"))
      }
    }
  }
}
