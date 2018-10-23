package csw.scala.ml

/**
  * 作用:
  *
  * @author chensw
  * @since 2018/9/6
  */
import scala.collection.mutable

object KNNTest {

  def getGroup: Array[Array[Double]] = {
    Array(Array(1.0, 1.1), Array(1.0, 1.0), Array(0, 0), Array(0, 0.1))
  }
  def getLabels: Array[Char] = {
    Array('A', 'A', 'B', 'B')
  }

  def classify0(inX: Array[Double], dataSet: Array[Array[Double]], labels: Array[Char], k: Int): Char = {
//    val dataSetSize = dataSet.length
    val sortedDisIndicies = dataSet.map { x =>
      val v1 = x(0) - inX(0)
      val v2 = x(1) - inX(1)
      v1 * v1 + v2 * v2
    }.zipWithIndex.sortBy(f => f._1).map(f => f._2)
    val classCount: mutable.Map[Char, Int] = mutable.Map.empty
    for (i <- 0 until k) {
      val voteIlabel = labels(sortedDisIndicies(i))
      classCount(voteIlabel) = classCount.getOrElse(voteIlabel, 0) + 1
    }
    classCount.toArray.minBy(f => -f._2)._1
  }
  def main(args: Array[String]): Unit = {
    println(classify0(Array(1.0, 0.9), getGroup, getLabels, 3))
  }
}