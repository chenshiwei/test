package csw.scala.other

import com.alibaba.fastjson.JSON

object IPTest extends App {

    val t = System.currentTimeMillis()
    val regex = "(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)".r
    println(regex.findFirstIn("10.99.103").isEmpty)
    println("45, 64, 4, 6, 8".split("->").length)

    import scala.collection.mutable

    val timeMap: mutable.Map[String, Long] = mutable.Map()
    timeMap.+=(("1", 3))
    timeMap.+=(("1", 2))
    timeMap.+=(("2", 3))
    timeMap.foreach(println)

    import scala.collection.JavaConverters._

    println(JSON.toJSON(Map("1" -> "3", "2" -> "4").asJava).toString())
    println(JSON.toJSON(Map("2" -> "4", "1" -> "3").asJava).toString()
        == JSON.toJSON(Map("1" -> "3", "2" -> "4").asJava).toString())
    println(System.currentTimeMillis() - t)

    val array = timeMap.toArray
    array
}
