package day03_scala_wordCount02

/*
 @author gyp
 @create 2019/8/7
*/
case class WordCountMsg(filenameList: String)

case class WordCountActorResult(wordCountMap: Map[String, Int])
