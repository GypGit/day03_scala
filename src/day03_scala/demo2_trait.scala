package day03_scala

/*
 @author gyp
 @create 2019/8/5
*/
object demo2_trait {

  trait MessageSender {
    def send(msg: String)
  }

  trait MessageReceiver {
    def receive: String
  }
  class MessageWorker extends MessageSender with MessageReceiver {
    override def send(msg: String): Unit =println(s"${msg}发送的消息")

    override def receive: String = "你好,要修改"
  }

  def main(args: Array[String]): Unit = {
    val worker = new MessageWorker
    worker.send("yaoxiugai")

    println(worker.receive)
  }

}
