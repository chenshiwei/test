package csw.scala.test

object OrderTest extends App {
    val map = Map("q" -> 64, "w" -> 35, "e" -> 99, "r" -> 4)
    for (entry <- map.toSeq.sortWith(_._1 > _._1).toMap) println(entry)
    val seq = Seq(1, 3, 5, 749, 7, 95, 655, 487, 6, 47, 7448, 84, 7)
    println(seq.sortWith(_ > _))
    println(seq.sorted)
    println(map.toSeq.sortBy(_._2)(Ordering.Int.reverse))
}    
