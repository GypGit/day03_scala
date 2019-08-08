package day03_scala_actor

import java.util.concurrent.TimeUnit

import scala.actors.Actor

/*
 @author gyp
 @create 2019/8/6
*/
object demo2_actor {

  object ActorSender extends Actor {
    override def act(): Unit = {
      while (true) {
        ActorReceiver ! "hello"
        TimeUnit.SECONDS.sleep(3)
      }
    }
  }

  object ActorReceiver extends Actor {
    override def act(): Unit = {
      loop {
        react {
          case msg: String => println("接收到消息：" + msg)
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    ActorSender.start()
    ActorReceiver.start()
  }

}
