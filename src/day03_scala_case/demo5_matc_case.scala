package day03_scala_case

/*
 @author gyp
 @create 2019/8/5
*/
object demo5_match_case {

  case class Custumer(name:String,age:Int)
  case class Order(id:String)

  def main(args: Array[String]): Unit = {
    val custumer = Custumer("张三", 20)
    val order = Order("001")
    val result: String = order match {
      case _: Custumer => "Cus"
      case _: Order => "Ord"
    }
    println(result)
  }
}
