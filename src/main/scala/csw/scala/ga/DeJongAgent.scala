package csw.scala.ga

import scala.collection.mutable

/**
  * 作用:
  *
  * @author chensw
  * @since 2018/8/28
  */
class DeJongAgent(val len: Int) extends Agent {
    geneLength = 10
    chrome = new Chrome(len)
    private var x1: Double = _
    private var x2: Double = _
    //自变量
    private var x3: Double = _

    //自变量

    //随机生成个体
    override def generateAgent(): Unit = {
        x1 = Math.random() * 10.24 - 5.12
        x2 = Math.random() * 10.24 - 5.12
        x3 = Math.random() * 10.24 - 5.12

        //编码并计算适应度
        coding()
        calTargetValue()
        calFitness()


    }

    //二进制编码
    override def coding(): Unit = {
        chrome.setGene(0, 9, codingValue(x1))
        chrome.setGene(10, 19, codingValue(x2))
        chrome.setGene(20, 29, codingValue(x3))

    }

    /**
      * 对x进行二进制编码，并将不足10位的部分用0补齐
      */
    def codingValue(x: Double): String = {
        val y = (x + 5.12) * 1023 / (5.12 * 2)
        val code = Integer.toBinaryString(y.toInt).toCharArray
        var codeBuf = new mutable.ArrayBuffer[Char]()
        codeBuf ++= code
        //    var i = 0
        for (_ <- code.length until geneLength) {
            codeBuf.insert(0, '0')
        }
        codeBuf.toArray.mkString

    }

    //计算个体适应度
    override def calFitness(): Unit = {
        fitness = getTargetValue
    }

    //获取目标函数
    override def calTargetValue(): Unit = {
        decode()
        targetValue = dejong(x1, x2, x3)
    }

    //解码
    override def decode(): Unit = {
        x1 = decodeGene(chrome.getGene(0, 9))
        x2 = decodeGene(chrome.getGene(10, 19))
        x3 = decodeGene(chrome.getGene(20, 29))

    }

    //对每个基因解码
    def decodeGene(gene: String): Double = Integer.parseInt(gene, 2) / 1023.0 * 10.24 - 5.12

    def dejong(x1: Double, x2: Double, x3: Double): Double = Math.pow(x1, 2) + Math.pow(x2, 2) + Math.pow(x3, 2)

    override def toString: String = "函数值:" + getfitness


}
