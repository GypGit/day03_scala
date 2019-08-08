package day03_scala_case

/*
 @author gyp
 @create 2019/8/6
*/
object demo18_UD {

  class Person
  class Policeman extends Person
  class Superman extends Policeman

  def demo[T >: Policeman <:Person](array:Array[T]) = println(array)

  def main(args: Array[String]): Unit = {
    demo(Array(new Person))
    demo(Array(new Policeman))
    // 编译出错：Superman是Policeman的子类
//     demo(Array(new Superman))
  }
}
