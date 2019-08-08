package day03_scala_case

/*
 @author gyp
 @create 2019/8/6
*/
object demo13_regex {
  def main(args: Array[String]): Unit = {
    val emlList =List("38123845@qq.com", "a1da88123f@gmail.com", "zhansan@163.com", "123afadff.com")
    val regex=""".+@(.+)\..+""".r
    val result= emlList.map {
      case x@regex(company) => s"${x}=>${company}"
      case x => x + "=>无"
    }
    println(result)
  }


}
