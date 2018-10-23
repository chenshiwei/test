package csw.scala.ml

/**
  * 作用:
  *
  * @author chensw
  * @since 2018/9/6
  */
import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.util.Random

object LogisticTest {

  def loadDataSet(): (Array[Array[Double]], Array[Double]) = {
    val dataMat = new ArrayBuffer[Array[Double]]
    val labelMat = new ArrayBuffer[Double]
    val fr = Source.fromFile("LogisticTestSet.txt")
    for (line <- fr.getLines()) {
      val lineArr = line.trim().split("\t").map(_.toDouble)
      dataMat.append(Array(1.0, lineArr(0), lineArr(1)))
      labelMat.append(lineArr(2))
    }
    (dataMat.toArray, labelMat.toArray)
  }

  def sigmoid(inX: Double): Double = {
    1.0 / (1 + math.exp(-inX))
  }

  def stocGradAscent1(dataMatrix: Array[Array[Double]], classLabels: Array[Double], numIter: Int = 150): Array[Double] = {
    val m = dataMatrix.length
    val n = dataMatrix(0).length
    var weights = Array.fill(n)(1.0)
    for (j <- 1 to numIter) {
      val dataIndex: ArrayBuffer[Int] = ArrayBuffer.empty
      for (loc <- 0 until m) dataIndex.append(loc)
      for (i <- 0 until m) {
        val alpha = 4 / (1.0 + j + i) + 0.0001
        val randIndex = Random.nextInt(dataIndex.length)
        //go to 0 because of the constant
        val rowZipWeight = dataMatrix(dataIndex(randIndex)).zip(weights)
        val h = sigmoid(rowZipWeight.map(x => x._1 * x._2).sum)
        val error = classLabels(randIndex) - h
        weights = rowZipWeight.map(x => x._1 + alpha * error * x._2)
        dataIndex.remove(randIndex)
      }
    }
    weights
  }

  def classifyVector(inX: Array[Double], weights: Array[Double]): Double = {
    val prob = sigmoid(inX.zip(weights).map(x => x._1 * x._2).sum)
    if (prob > 0.5) 1.0 else 0.0
  }

  def main(args: Array[String]): Unit = {
    val dataSet = loadDataSet()
    val dataMatrix = dataSet._1
    val classLabels = dataSet._2
    val weights = stocGradAscent1(dataMatrix, classLabels,500)
    val result = dataMatrix.map(x => classifyVector(x, weights))
    println(result.mkString("\n"))
    println(result.zip(classLabels).count(x => x._1 == x._2).toDouble / classLabels.length)
  }
}
