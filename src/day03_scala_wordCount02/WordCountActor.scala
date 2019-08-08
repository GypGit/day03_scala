package day03_scala_wordCount02

import scala.actors.Actor
import scala.io.{BufferedSource, Source}

/*
 @author gyp
 @create 2019/8/7
*/
class WordCountActor extends Actor {
  override def act(): Unit = {
    loop {
      react {
        case WordCountMsg(fileName) =>
          println(fileName)
          //获取迭代器
          val iterator: Iterator[String] = Source.fromFile(fileName).getLines()
          val list: List[String] = iterator.toList
          println(list)
          //1.对文件的单词进行flatmap
          //变成一个个数组  List(hadoop,sqoop,spark,hadoop,sqoop,spark)
          val WordCountList: List[String] = list.flatMap(_.split(" "))
          //2.然后进行map转换为元组(hadoop->1)
          val tuples: List[(String, Int)] = WordCountList.map(_ -> 1)
          //3.然后进行分组 Map(hadoop,List((hadoop,1),(spark,1)))
          val groupByKey: Map[String, List[(String, Int)]] = tuples.groupBy(_._1)
          //4.进行reduce
          val result: Map[String, Int] = groupByKey.map{
            case groupByKey=>
              groupByKey._1->groupByKey._2.map(_._2).sum
          }
          println(result)
          sender ! WordCountActorResult(result)
      }
    }
  }
}
