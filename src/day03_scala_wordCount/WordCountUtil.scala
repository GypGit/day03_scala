package day03_scala_wordCount

/*
 @author gyp
 @create 2019/8/6
*/
object WordCountUtil {
  def reduce(tuples: List[(String, Int)]) = {

    //todo 5.将相同单词放到一起 形成一个key value样式的列表
    //Map(hadoop,List((hadoop->1),(hadoop->1)))
    val groupMap: Map[String, List[(String, Int)]] = tuples.groupBy(_._1)
    println("第五步:" + groupMap)

    //todo 6.求和
    val WordCountMapResult: Map[String, Int] = groupMap.map {
      groupMap => groupMap._1 -> groupMap._2.map(_._2).sum
    }
    WordCountMapResult
  }
}
