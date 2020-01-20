package csw.scala.test

object Test extends App {

    import scala.io.Source
    val source = Source.fromFile("F:\\数据\\2018-123.csv", "UTF-8")
    val lineIterator: Iterator[String] = source.getLines()
    lineIterator.foreach(println)
    source.close
}



