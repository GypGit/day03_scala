package day04_scala.part01


import java.io.File

import scala.io.Source

/*
 @author gyp
 @create 2019/8/8
*/
object demo2 {

  class RichFile(val file: File) {
    def read() = {
      Source.fromFile(file).mkString
    }
  }


  def main(args: Array[String]): Unit = {
    implicit def file2RichFile(file: File)= {
      new RichFile(file)
    }
    val file = new File("./data/1.txt")
    println(file.read())


  }
}
