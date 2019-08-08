package day03_scala_case

import scala.io.StdIn

/*
 @author gyp
 @create 2019/8/5
*/
object demo4_match {
  def main(args: Array[String]): Unit = {
    val a=StdIn.readInt()
//    val b:Any=1
//    val c:Any=1.0

    val result: String = a match {
      case a if a>=0 && a<= 3=> "[0-3]"
      case a if a>=3 && a<= 6=> "[3-6]"
      case a if a>=6 && a<= 10=> "[6-10]"
      case a => "wu"
    }
    println(result)

  }
}
