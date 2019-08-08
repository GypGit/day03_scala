package day03_scala_case

/*
 @author gyp
 @create 2019/8/5
*/
object demo7_match {
  def main(args: Array[String]): Unit = {
    val list = List(0,1,2)
    list match {
      case 0::Nil =>println("1")
      case 0::tail =>println("2")
      case 0::y::Nil =>println("3")
      case _ =>println("4")
    }
  }
}
