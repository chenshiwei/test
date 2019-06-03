package csw.scala.ml

/**
  * 作用:
  *
  * @author chensw
  * @since 2018/9/6
  */

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, Map}


object DTreeTest {

    class MyTree(a: String, b: mutable.Map[Int, MyTree]) {
        val value: String = a
        var nodes: mutable.Map[Int, MyTree] = b
    }

    def createDataSet(): (Array[(Array[Int], String)], Array[String]) = {
        val dataSet = Array((Array(1, 1), "yes"), (Array(1, 1), "yes"),
            (Array(1, 0), "no"), (Array(0, 1), "no"), (Array(0, 1), "no"))
        // 这应该称为属性 而不是标签
        val TreeAttributes = Array("no surfacing", "flippers")
        (dataSet, TreeAttributes)
    }

    def calShannonEnt(dataSet: Array[Tuple2[Array[Int], String]]): Double = {
        val numEntries = dataSet.length
        var labelCounts: Map[String, Int] = Map.empty
        for (featVec <- dataSet) {
            val currentLabel = featVec._2
            labelCounts(currentLabel) = labelCounts.getOrElse(currentLabel, 0) + 1
        }
        var shannoEnt = 0.0
        for (value <- labelCounts.values) {
            val prob = value.toDouble / numEntries
            shannoEnt -= prob * math.log(prob) / math.log(2)
        }
        shannoEnt
    }

    def splitDataSet(dataSet: Array[Tuple2[Array[Int], String]], axis: Int, value: Int): Array[(Array[Int], String)] = {
        var retDataSet: ArrayBuffer[Tuple2[Array[Int], String]] = ArrayBuffer.empty
        for (featVec <- dataSet) {
            if (featVec._1(axis) == value) {
                val reducedFeatvec = featVec._1.zipWithIndex.filter(_._2 != axis).map(_._1)
                retDataSet.+=((reducedFeatvec, featVec._2))
            }
        }
        retDataSet.toArray
    }

    def chooseBestFeatureToSplit(dataSet: Array[Tuple2[Array[Int], String]]): Int = {
        val baseEntropy = calShannonEnt(dataSet)
        var bestInfoGain = 0.0
        var bestFeature = -1
        for (i <- dataSet(0)._1.indices) {
            val uniqueVals = dataSet.map(_._1(i)).toSet
            var newEntropy = 0.0
            for (value <- uniqueVals) {
                val subDataSet = splitDataSet(dataSet, i, value)
                newEntropy += subDataSet.length.toDouble / dataSet.length * calShannonEnt(subDataSet)
            }
            val infoGain = baseEntropy - newEntropy
            if (infoGain > bestInfoGain) {
                bestInfoGain = infoGain
                bestFeature = i
            }
        }
        bestFeature
    }

    def creatTree(dataSet: Array[Tuple2[Array[Int], String]], attribute: Array[String]): MyTree = {
        val classList = dataSet.map(_._2)
        if (classList.count(_ == classList(0)) == classList.length) {
            new MyTree(classList(0), mutable.Map.empty)
        } else if (dataSet.length == 1) {
            val str = classList.map((_, 1)).groupBy(_._1).map(x => (x._1, x._2.map(_._2).sum)).toList.maxBy(_._2)._1
            new MyTree(str, mutable.Map.empty)
        } else {
            val bestFeat = chooseBestFeatureToSplit(dataSet)
            val bestFeatAttribute = attribute(bestFeat)
            var myTree = new MyTree(bestFeatAttribute, mutable.Map.empty)
            var Vattribute = attribute
            Vattribute = Vattribute.filter(_ != bestFeatAttribute)
            val uniqueVals = dataSet.map(_._1(bestFeat)).distinct
            for (value <- uniqueVals) {
                myTree.nodes.+=(value -> creatTree(splitDataSet(dataSet, bestFeat, value), Vattribute))
            }
            myTree
        }
    }

    def classify(inputTree: MyTree, attribute: Array[String], testVec: Array[Int]): String = {
        var classLabel = ""
        val firstStr: String = inputTree.value
        val secondTrees: mutable.Map[Int, MyTree] = inputTree.nodes
        val index: Array[(String, Int)] = attribute.zipWithIndex
        val featIndex = index.filter(_._1 == firstStr)(0)._2
        for (key <- secondTrees.keySet) {
            if (testVec(featIndex) == key) {
                if (secondTrees(key).nodes.isEmpty)
                    return secondTrees(key).value
                else classLabel = classify(secondTrees(key), attribute, testVec)
            }
        }
        classLabel
    }

    def main(agrs: Array[String]): Unit = {
        val name = 1
        val DataSet = createDataSet()
        val dataSet = DataSet._1
        val attribute = DataSet._2
        val inputTree = creatTree(dataSet, attribute)
        println(classify(inputTree, attribute, Array(1, 1)))
    }
}