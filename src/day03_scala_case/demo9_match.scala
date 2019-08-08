package day03_scala_case

/*
 @author gyp
 @create 2019/8/5
*/
object demo9_match {
  def main(args: Array[String]): Unit = {
    val list: List[Int] = (1 to 10).toList
    val List(_,x,y,z,_*)=list
    println(x,y,z)
  }


}
