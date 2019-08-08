package day04_scala.part01

/*
 @author gyp
 @create 2019/8/8
*/
object demo3 {
  def quote(str:String)(implicit Li:(String,String))={
    Li._1+str+Li._2
  }
  object Implicitparam{
    implicit val extra=("<<",">>")
  }

  def main(args: Array[String]): Unit = {
    import Implicitparam.extra
    println(quote("你好"))
  }
}
