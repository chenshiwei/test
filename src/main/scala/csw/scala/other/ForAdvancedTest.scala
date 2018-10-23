package csw.scala.other

/**
  * 作用:
  *
  * @author chensw
  * @since 2018/8/28
  */

object ForAdvancedTest {
  def main(args: Array[String]): Unit = {
    for (i <- List(1,2,3,4,5)) println(i)

    //index绑定了一个别名,叫Flink,内部是模式匹配,匹配到Flink后设置别名给index
    for (index@"Flink" <- List("Hadoop","Spark","Flink")) {
      println(index)
    }

    //for与元祖模式匹配
    for ((language,"Hadoop") <- Set("Scala" -> "Spark","java" -> "Hadoop")) {
      println(language)
    }

    //类型限定
    for ((k,_: Int) <- List("spark" -> 5,"Hadoop" -> "hdfs")) {
      println(k)
    }
  }


}
