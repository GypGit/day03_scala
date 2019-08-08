package day03_scala_wordCount02

import java.io.File

import scala.actors.Future

/*
 @author gyp
 @create 2019/8/7
*/
object MainActor {
  def main(args: Array[String]): Unit = {
    //1.1.定义文件名字
    val DIR_PATH = "./data/"
    //1.2.获取文件列表并打印
    val file = new File(DIR_PATH)
    val fileList: List[String] = file.list.toList.map(DIR_PATH+_)
    println(fileList)
    //2.1将文件名和Actor信息zip到一起
    val wordCountActors: List[WordCountActor] = fileList.map {
      fileList => new WordCountActor
    }
    val tuples: List[(WordCountActor, String)] = wordCountActors.zip(fileList)
    println(tuples)

    //3.1发送信息给actor
    val futureList: List[Future[Any]] = tuples.map {
      futureList =>
        //启动Actor
        futureList._1.start
        //发送消息
        val future: Future[Any] = futureList._1 !! WordCountMsg(futureList._2)
        future
    }
    while (futureList.filter(!_.isSet).size != 0){}

    //4.转换收到的数据
    val allWordCountMap: List[Map[String, Int]] = futureList.map {
      futureList => futureList.apply.asInstanceOf[WordCountActorResult].wordCountMap
    }
    println(allWordCountMap)
    val flatten: List[(String,Int)] = allWordCountMap.flatten
    println(flatten)
    val groupByKey: Map[String, List[(String, Int)]] = flatten.groupBy(_._1)
    //4.进行reduce
    val result: Map[String, Int] = groupByKey.map{
      case groupByKey=>
        groupByKey._1->groupByKey._2.map(_._2).sum
    }
    println("最终结果:"+result)

  }

}
