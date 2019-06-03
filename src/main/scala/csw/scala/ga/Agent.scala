package csw.scala.ga

/**
  * 作用:
  *
  * @author chensw
  * @since 2018/8/28
  */
trait Agent extends Cloneable {

    protected var chrome: Chrome = _
    //染色体编码
    protected var geneLength: Int = _
    //基因长度
    protected var fitness: Double = _
    //适应度
    protected var targetValue: Double = _
    //目标函数


    def coding()

    //编码
    def decode()

    //解码
    def calFitness()

    //计算个体适应度
    def generateAgent()

    //随机生成个体
    def calTargetValue() //获取目标函数

    def getfitness: Double = fitness

    def getTargetValue: Double = targetValue

    def getChromLen: Int = chrome.length

    def setChrom(begin: Int, end: Int, gene: String): Boolean = chrome.setGene(begin, end, gene)

    def getChrom(begin: Int, end: Int): String = chrome.getGene(begin, end)

    def mutateSingleBit(index: Int) {
        val g = chrome.getGene(index, index)
        val newg = if (g.equals("0")) "1" else "0"
        chrome.setGene(index, index, newg)
    }

    override def clone: Agent = {
        val a = super.clone.asInstanceOf[Agent]
        a.chrome = chrome.clone
        a
    }

}
