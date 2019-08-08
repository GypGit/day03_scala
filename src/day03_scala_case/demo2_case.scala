package day03_scala_case

/*
 @author gyp
 @create 2019/8/5
*/
object demo2_case {
  trait gender
  case object male extends gender
  case object female extends gender
  case class Person(name:String,sex: gender)

  def main(args: Array[String]): Unit = {
    val zs = Person("zs",male)
    println(zs)
  }

}
