package day03_scala_case

/*
 @author gyp
 @create 2019/8/5
*/
object demo10_option {
  def div(a: Double, b: Double): Option[Double] = {
    if (b != 0) {
      Some(a / b)
    } else {
      None
    }
  }

  def main(args: Array[String]): Unit = {
    val result: Option[Double] = div(10,0)
    val result1: Double = result.getOrElse(0)
    println(result1)
  }
}
