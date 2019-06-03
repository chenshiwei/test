package csw.scala.akka

import akka.actor._


/**
  * 作用:
  *
  * @author chensw
  * @since 2018/8/30
  */

import akka.actor.{Actor, ActorSystem, Props}

class HelloActor extends Actor {
    def receive: PartialFunction[Any, Unit] = {
        case "hello" => println("您好！")
        case _ => println("您是?")
    }
}

object Main extends App {
    val system = ActorSystem("HelloSystem")
    // 缺省的Actor构造函数
    val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
    helloActor ! "hello"
    helloActor ! "喂"
}

