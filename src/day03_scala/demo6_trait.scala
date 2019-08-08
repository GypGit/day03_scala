package day03_scala

/*
 @author gyp
 @create 2019/8/5
*/
object demo6_trait {

  trait Logger {
    def log(msg:String)
    def info(msg:String)=log("INFO:"+msg:String)
    def warn(msg:String)=log("WARN:"+msg:String)
    def error(msg:String)=log("ERROR:"+msg:String)
  }
  class ConsoleLogger extends Logger(){
    override def log(msg: String): Unit = println(msg)
  }

  def main(args: Array[String]): Unit = {
    val logger = new ConsoleLogger
    logger.info("nihai")
    logger.warn("nihai")
    logger.error("nihai")
  }
}
