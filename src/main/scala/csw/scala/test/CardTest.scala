package csw.scala.test

import java.util.Random

object CardTest extends Enumeration {

    val M = Value("♣")
    val T = Value("♠")
    val H = Value("♥")
    val F = Value("♦")
    var ss = "Hello"

    //  println(Card.M)
    //  println(Card.F)
    //  println(Card.H)
    //  println(Card.F)
    override def toString() = {
        (CardTest.M.toString() + CardTest.F.toString() + CardTest.H.toString() + CardTest.T.toString())
        //ERROR:
        //    (Card.M.toString()+Card.F.toString(),Card.H.toString(),Card.T.toString()
        //    (Card.M+Card.F+Card.H+Card.T).toString()
    }

    def main(arg: Array[String]) {

        val rand = new Random
        val f = List(M, T, H, F)
        val K = List("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
        (0 until 4).foreach(_ =>
            println(s"${f(rand.nextInt(4))}${K(rand.nextInt(13))}"))

    }
}  

