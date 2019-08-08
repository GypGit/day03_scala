package day03_scala_case

/*
 @author gyp
 @create 2019/8/6
*/
object demo15_extractor {

  class Student(var name: String, var age: Int)

  object Student {
    def apply(name: String, age: Int): Student = new Student(name, age)

    def unapply(student: Student) = {
      val tuple = (student.name, student.age)
      Some(tuple)
    }
  }

  def main(args: Array[String]): Unit = {
    val zs = new Student("zs",1)
    zs match{
      case Student(name,age) => println(s"${name}=>${age}")
    }
  }

}
