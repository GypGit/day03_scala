package day03_scala

/*
 @author gyp
 @create 2019/8/5
*/
object demo3_Object {

  trait Logger {
    def log(msg:String)
  }
  object ConsoleLogger extends Logger {
    override def log(msg: String): Unit = println("控制台消息:"+msg)
  }

  def main(args: Array[String]): Unit = {
    ConsoleLogger.log("Nihao")
  }

}
