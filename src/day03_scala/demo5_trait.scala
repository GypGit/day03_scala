package day03_scala

import java.text.SimpleDateFormat
import java.util.Date

/*
 @author gyp
 @create 2019/8/5
*/
object demo5_trait {
  trait Logger{
    val dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm")
    def log(msg:String)
  }
  class ConsoleLogger extends Logger {
    override def log(msg: String): Unit ={
      val info =s"${dateFormat.format(new Date())+msg}"
      println(info)
    }

  }

  def main(args: Array[String]): Unit = {
    val logger = new ConsoleLogger
    logger.log("nihao")
  }

}
