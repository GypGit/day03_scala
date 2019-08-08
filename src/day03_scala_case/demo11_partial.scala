package day03_scala_case

/*
 @author gyp
 @create 2019/8/6
*/
object demo11_partial {
  def main(args: Array[String]): Unit = {
    val part:PartialFunction[Int,String]={
    case 1 =>"a"
    case 2 =>"b"
    case 3 =>"c"
    case 4 =>"d"
    }
    println(part(2))
  }
  val list = (1 to 10).toList
  val list2=list.map {
    case x if x>=1 && x <=3 => "[1,3]"
    case x if x>=4 && x <=6 => "[4,6]"
    case x if x>=7=> "[7,*]"
  }
println(list2)

}
