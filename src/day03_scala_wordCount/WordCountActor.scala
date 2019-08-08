package day03_scala_wordCount

import scala.actors.Actor
import scala.io.Source

/*
 @author gyp
 @create 2019/8/6
*/
class WordCountActor extends Actor {
  //接收消息处理数据并将结果信息返回给MainActor
  override def act(): Unit = {
    loop {
      react {
        case WordCountTask(filename) =>
          println("文件名为:" + filename)

          //todo 1.读取每个文件,统计每个文件的单词计数,获得到迭代器
          val iterator: Iterator[String] = Source.fromFile(filename).getLines()
          //          println("第一步:"+iterator)

          //todo 2.将迭代器中的数据转为列表
          // List(hadoop sqoop hadoop, hadoop hadoop flume, hadoop hadoop hadoop, spark)
          // List(flink hadoop hive, hadoop sqoop hadoop, hadoop hadoop hadoop, spark)
          val lineList: List[String] = iterator.toList
          println("第二步:" + lineList)

          //todo 3.获取到每个单词后,用flatmap转化为一个个单词(hadoop,sqoop,spark)
          val wordList: List[String] = lineList.flatMap(_.split(" "))
          println("第三步:"+wordList)
          //todo 4.flatmap操作将数据转换为元组
          //(hadoop, 1), (hadoop, 1), (hadoop, 1), (spark, 1)
          val tuples: List[(String, Int)] = wordList.map(_ -> 1)
          println("第四步:" + tuples)

          val WordCountMapResult: Map[String, Int] = WordCountUtil.reduce(tuples)
          println("第六步:"+WordCountMapResult)
          //todo 7.将结果返回给MainActor
          sender ! WordCountMapList(WordCountMapResult)
      }
    }
  }
}
