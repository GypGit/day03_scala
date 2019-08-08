package day03_scala_case

/*
 @author gyp
 @create 2019/8/6
*/
object demo19_T {

  class Super

  class Sub extends Super

  class Temp[T]
  class Temp2[-T]
  class Temp3[+T]

  def main(args: Array[String]): Unit = {
    //非变
    val temp1 = new Temp[Sub]
//    val sub:Temp[Super] = temp1

    //协变
    val temp2 =new Temp3[Sub]
    val temp22:Temp3[Super]= temp2
    //逆变
    val temp3 = new Temp2[Super]
    val temp33:Temp2[Sub]= temp3
  }
}
