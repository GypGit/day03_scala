package day03_scala

/*
 @author gyp
 @create 2019/8/5
*/
object demo1_trait {
  trait Logger{
    def log(msg:String)
  }
  class ConsoleLogger extends Logger {
    override def log(msg: String): Unit = print("nihao"+msg)
  }

  def main(args: Array[String]): Unit = {
    val logger = new ConsoleLogger
    logger.log("zhangsan")
  }
}
