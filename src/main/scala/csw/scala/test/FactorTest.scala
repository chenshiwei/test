package csw.scala.test

import scala.io.StdIn

object FactorTest extends App {

  while (true) {
    val sb = new StringBuilder("")
    var in = StdIn.readLine("n = ").toInt
    sb.append(s"$in = ")
    var m = in

    def yz(n: Int): Int = {
      2.to(math.sqrt(n).toInt).foreach(i => if (n % i == 0) return i)
      n
    }

    while (m > 1) {
      val f = yz(m)
      sb.append(s"$f X ")
      m /= f
    }

    println(sb.substring(0, sb.length - 2))

  }


}
