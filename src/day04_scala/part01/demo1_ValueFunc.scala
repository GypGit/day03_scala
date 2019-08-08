package day04_scala.part01

/*
 @author gyp
 @create 2019/8/8
*/
object demo1_ValueFunc {
  def main(args: Array[String]): Unit = {
    val star:Int=>String=(num:Int)=>"*" * num
    val a = List(1,2,3,4,5)
    val strings: List[String] = a.map(x=>"*"*x)
    println(strings)

  }
}
