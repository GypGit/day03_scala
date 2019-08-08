package day03_scala

/*
 @author gyp
 @create 2019/8/5
*/
object demo9_trait {

  class MyUtils {
    def printMsg(msg: String): Unit = {
      println(msg)
    }
  }
  trait Logger extends MyUtils{
    def log (msg:String)=println("Logger"+msg)
  }
  class Person(name:String) extends Logger{
    def sayHello=log(name+"你好")
  }

  def main(args: Array[String]): Unit = {
    val zs = new Person("zs")
    zs.sayHello
  }
}
