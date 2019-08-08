package day03_scala_actor

import scala.actors.{Actor, Future}

/*
 @author gyp
 @create 2019/8/6
*/
object demo6_actor {
  case class Message(id:Int, message:String)
  case class ReplyMessage(message:String, name:String)

  object MsgActor extends Actor {
    override def act(): Unit = {
      loop {
        react {
          case Message(id,message)=>println(s"MsgActor接收到消息：${id}/${message}")
            sender ! ReplyMessage("收到消息","Jim")
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    MsgActor.start()
    val future: Future[Any] = MsgActor !! Message(11,"你")
    while (!future.isSet){}
      val message: ReplyMessage = future.apply().asInstanceOf[ReplyMessage]
    println(message)
  }
}
