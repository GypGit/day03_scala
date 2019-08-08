package day03_scala_case

/*
 @author gyp
 @create 2019/8/6
*/
object demo17_T {
  case class Pair[T](var a:T,b:T)

  def main(args: Array[String]): Unit = {
    var a = List(
      Pair("hadoop",1)
//      Pair("sdsd",34341.0241)
//      Pair(51,54)
//      Pair(2534,"sdfsd")
    )
    println(a)
  }
}
