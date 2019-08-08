package day03_scala_wordCount

import java.io.File
import scala.actors.Future

/*
 @author gyp
 @create 2019/8/6
*/
object MainActor {
  def main(args: Array[String]): Unit = {
    //todo 1.1.获取要读取的文件
    val DIR_PATH = "./data/"
    val dataDir = new File(DIR_PATH)
    //todo 1.2.读取文件
    val fileList: List[String] = dataDir.list().toList.map(DIR_PATH + _)
    //todo 1.3.构建文件列表
    println(fileList)
    //todo 2.1 创建一个actor并将文件名与actor进行合并
    val wordCountActorList: List[WordCountActor] = fileList.map {
      x => new WordCountActor
    }
    //todo 2.2将actor和文件名zip起来
    val wordCountActorAndFileList: List[(WordCountActor, String)] = wordCountActorList.zip(fileList)
    println(wordCountActorAndFileList)
    //todo 3.1发送文件名和actor信息给wordCountActor
    val futureList: List[Future[Any]] = wordCountActorAndFileList.map {
      list =>
        //启动Actor
        list._1.start
        //发送消息
        val future: Future[Any] = list._1 !! WordCountTask(list._2)
        future
    }

    //todo 4.等待所有actor将处理后的数据返回 ,然后结果合并
    while (futureList.filter(!_.isSet).size != 0) {}
    val allWordCountMap: List[Map[String, Int]] = futureList.map {
      futureList => futureList.apply.asInstanceOf[WordCountMapList].wordCountMap
    }
    println("MainActor收到的消息:" + allWordCountMap)
    val WordCountMap: List[(String, Int)] = allWordCountMap.flatten
    val result: Map[String, Int] = WordCountUtil.reduce(WordCountMap)

    println("最终结果:" + result)

  }

}
