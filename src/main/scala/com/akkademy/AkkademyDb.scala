package com.akkademy

import akka.actor.Actor
import akka.event.Logging
import com.akkademy.messages.Models.SetRequest

import scala.collection.mutable

/**
  * Description: 
  * Author: dick
  * Time: 2018/10/26 下午4:49
  */
class AkkademyDb extends Actor {
  val map = new mutable.HashMap[String, Object]
  val log = Logging(context.system, this)

  override def receive: Receive = {
    case SetRequest(key, value) => {
      log.info("received SetRequest - key: {} value: {}", key, value)
      map.put(key, value)
    }

    case o => log.info("received unknown message: {}", o)
  }
}
