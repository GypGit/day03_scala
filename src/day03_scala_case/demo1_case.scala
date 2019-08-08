package day03_scala_case

/*
 @author gyp
 @create 2019/8/5
*/
object demo1_case {

  case class Person(name: String, age: Int)

  def main(args: Array[String]): Unit = {
    val person1: Person = Person("zs", 12)
    val person2: Person = Person("zs", 12)
    val person3: Person = person1.copy(name = "z")
    println(person1.hashCode())
    println(person2.hashCode())
    println(person1 == person3)
  }
}
