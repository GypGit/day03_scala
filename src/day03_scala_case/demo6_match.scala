package day03_scala_case

/*
 @author gyp
 @create 2019/8/5
*/
object demo6_match {
  def main(args: Array[String]): Unit = {
    val array = Array(1,2,3,3)
    array match {
      case Array(1,x,y)=>(println(x,y))
      case Array(1)=>(println(1))
      case Array(1,_*)=>(println("....."))
      case _ => println("wu")
    }
  }



}
