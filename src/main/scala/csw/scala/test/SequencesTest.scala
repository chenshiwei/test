package csw.scala.test

object SequencesTest extends App {

  val t = System.currentTimeMillis()
  val result = Array(
    Array(Array(1, 2, 3), Array(4, 5)),
    Array(Array(2, 3, 4), Array(5)),
    Array(Array(1, 2), Array(4)),
    Array(Array(1, 3, 4), Array(4)),
    Array(Array(1, 2, 3), Array(5)),
    Array(Array(1, 3), Array(4, 5)),
    Array(Array(1, 3), Array(4, 5), Array(1, 6)),
    Array(Array(2, 3), Array(4)))
  def maxSequences(a: Array[Array[Int]]): Boolean = {
    val filter = result.filter(b => b != a && b.length == a.length)
    filter.isEmpty ||
      !filter.map(b => b.zip(a).map(c => c._2.toSet.diff(c._1.toSet).isEmpty).reduce(_ && _)).reduce(_ || _)
  }
  result.filter(maxSequences).foreach(f => println(f.map(_.mkString("[", ", ", "]")).mkString("[", ", ", "]")))
  println(System.currentTimeMillis() - t)
}
