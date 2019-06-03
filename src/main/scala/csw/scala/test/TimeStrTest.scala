package csw.scala.test

object TimeStrTest extends App {

    private def selectTimeStr(): String = {
        val startTime = 1502596800000L
        val endTime = 1502946000000L
        val sb = new StringBuilder("(")
        val len = (endTime - startTime) / (3600000L)
        for (i <- 0 until len.toInt) sb.append(startTime + i * 3600000L).append(",")
        sb.deleteCharAt(sb.lastIndexOf(",")).append(")").toString
    }

    println(selectTimeStr())
    println(1502596800000L.until(1502946000000L, 3600000L).mkString("(", ",", ")"))

    val str = "d,df,ds,as,,dko"
    val token = str.split(",")
    println(token.length)
    println(token(4) == "")
}
