package csw.scala.akka

import akka.actor._

case object PingMessage

case object PongMessage

case object StartMessage

case object StopMessage

class Ping(pong: ActorRef) extends Actor {
    var count = 0

    def receive = {
        case StartMessage =>
            incrementAndPrint
            pong ! PingMessage
        case PongMessage =>
            if (count > 9) {
                sender ! StopMessage
                println("ping stopped")
                context.stop(self)
            } else {
                incrementAndPrint
                sender ! PingMessage
            }
    }

    def incrementAndPrint {
        count += 1;
        println("ping")
    }
}

class Pong extends Actor {
    def receive = {
        case PingMessage =>
            println(" pong")
            sender ! PongMessage
        case StopMessage =>
            println("pong stopped")
            context.stop(self)
            context.system.shutdown()
    }
}

object PingPongTest extends App {
    val system = ActorSystem("PingPongSystem")
    val pong = system.actorOf(Props[Pong], name = "pong")
    val ping = system.actorOf(Props(new Ping(pong)), name = "ping")
    // start them going
    ping ! StartMessage
}