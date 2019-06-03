package csw.scala.akka

import scala.io.Source

/**
  * 作用:
  *
  * @author chensw
  * @since 2018/8/30
  */
object WordCount {
    def main(args: Array[String]): Unit = {
        val files = Array("e://tmp/2.txt", "e://tmp/3.txt", "e://tmp/1.txt")
        for (elem <- files) {
            val lines = Source.fromFile(elem).getLines().toList
            lines.flatMap(_.split(" ")).map(_ -> 1).groupBy(_._1).mapValues(_.size).foreach(println)
        }
    }
}
