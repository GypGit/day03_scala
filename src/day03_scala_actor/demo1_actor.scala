package day03_scala_actor

import scala.actors.Actor

/*
 @author gyp
 @create 2019/8/6
*/
object demo1_actor {
class actor1 extends Actor{
  override def act(): Unit = (1 to 10).foreach(println(_))
}
  class actor2 extends Actor{
    override def act(): Unit = (11 to 20).foreach(println(_))
  }

  def main(args: Array[String]): Unit = {
    val actor1 = new actor1
    val actor2 = new actor2
    actor1.start()
    actor2.start()
  }
}
