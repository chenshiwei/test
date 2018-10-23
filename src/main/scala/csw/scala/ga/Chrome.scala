package csw.scala.ga

/**
  * 作用:
  *
  * @author chensw
  * @since 2018/8/28
  */

class Chrome(val length: Int) extends Cloneable {
  var chrome = new Array[Char](length)

  //设置基因
  def setGene(begin: Int,end: Int,ge: String): Boolean = {

    if (ge.length > end - begin + 1) return false
    for (i <- begin to end) {
      chrome(i) = ge.charAt(i - begin)
    }

    true
  }

  //获取基因
  def getGene(begin: Int,end: Int): String = {
    chrome.subSequence(begin,end + 1).toString
  }

  override def toString: String = {
    chrome.mkString
  }

  override def clone: Chrome = {
    val c = super.clone.asInstanceOf[Chrome]
    c.chrome = chrome.clone
    c
  }

}
