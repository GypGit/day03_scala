package day03_scala_case

import scala.io.StdIn

/*
 @author gyp
 @create 2019/8/5
*/
object demo3_match {
  def main(args: Array[String]): Unit = {
    println("请输入一个词:")
    val name: String = StdIn.readLine()
    val result: String = name match {
      case "hadoop" => "大数据分布式存储和计算框架"
      case "zookeeper" => "大数据分布式协调服务框架"
      case "spark" => "大数据分布式存内存计算框架"
      case _ => "0"
    }
    println(result)
  }

}
