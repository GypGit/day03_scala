package day03_scala_case

/*
 @author gyp
 @create 2019/8/6
*/
object demo14_exception {
  def main(args: Array[String]): Unit = {
    try {
      val a = 10 / 0
      println(a)
    } catch {
      case ex => println(ex)
    }

    throw new Exception("sdfsdfsd")
  }
}
