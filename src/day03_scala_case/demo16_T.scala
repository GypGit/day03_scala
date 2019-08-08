package day03_scala_case

/*
 @author gyp
 @create 2019/8/6
*/
object demo16_T {
  def main(args: Array[String]): Unit = {
    def getMiddleElement[T](arr:Array[T])=arr(arr.length/2)

      println(getMiddleElement(Array(1, 2, 3, 4, 5)))
      println(getMiddleElement(Array("a", "b", "c")))
  }
}
