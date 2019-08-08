package day03_scala_case

/*
 @author gyp
 @create 2019/8/5
*/
object demo8_match {
  def main(args: Array[String]): Unit = {
    val tuple: (Int, Int, Int) = (4,2,5)
      tuple match{
        case (1,x,y)=>println("1")
        case (x,2,y)=>println("2")
        case (x,y,5)=>println("3")
        case _=>println("4")
      }
  }

}
