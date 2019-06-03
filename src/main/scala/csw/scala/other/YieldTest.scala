package csw.scala.other

import csw.scala.path

object YieldTest extends App {
    var s = s"huagug,dshixzhjij-asuh,"
    val sb = new StringBuilder(s)
    println(sb.stripSuffix(","))
    val a = (10 to 22)
    println(a)
    val w: Seq[Int] = for (i <- 1 to 10) yield i
    val w2: Seq[Int] = 1.to(10)
    w.toArray.foreach(println)
    println(w == w2)
    println(s"path = ${path}")
    val sa: Seq[Int] = 1.to(10).indices.map(_ * 2)
    private val array: Array[Int] = sa.toArray
    array.foreach(println)
}