package day03_scala

/*
 @author gyp
 @create 2019/8/5
*/
object demo7_trait {

  trait Logger {
    def log(msg: String): Unit = {
      println(msg)
    }
  }

    class UserService

  def main(args: Array[String]): Unit = {
    val service = new UserService with Logger
    service.log("nihao")
  }
}
