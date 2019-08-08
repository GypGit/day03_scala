package day03_scala_actor

import scala.actors.Actor

/*
 @author gyp
 @create 2019/8/6
*/
object demo4_actor {

  case class Message(id: Int, msg: String)

  case class ReplyMessage(id: Int, msg: String)
  object MsgActor extends Actor {
    override def act(): Unit = {
      loop {
        react {
          case Message(id,msg) => {
            println(s"接收到消息:${id}/${msg}")
            sender ! ReplyMessage(2,"完成任务")
          }
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    MsgActor.start()
    val apply: Any = MsgActor !? Message(1,"你好")
    println(apply.asInstanceOf[ReplyMessage])
  }
}
