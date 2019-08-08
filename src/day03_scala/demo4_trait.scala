package day03_scala

/*
 @author gyp
 @create 2019/8/5
*/
object demo4_trait {

  trait Logger {
    def log(msg: String): Unit = {
      print(msg + "你好")
    }
  }

  class UserService extends Logger {
    def add(): Unit = {
      log("zs")
    }
  }

  def main(args: Array[String]): Unit = {
    val service = new UserService
    service.add
  }

}
