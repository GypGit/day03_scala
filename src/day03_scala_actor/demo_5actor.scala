package day03_scala_actor

import scala.actors.Actor

/*
 @author gyp
 @create 2019/8/6
*/
object demo_5actor {
  case class Message(id:Int,msg:String)
  object MsgActor extends Actor {
    override def act(): Unit = {
      loop {
        react {
          case Message(id,msg)=>
            println(s"收到消息${id}++++++${msg}")
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    MsgActor.start()
    MsgActor ! Message(1,"dfdfd")
  }
}
