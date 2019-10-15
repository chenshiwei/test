package csw.scala.test

object Test extends App {

    val list = List(1, 2, 3)
    val i1 = list.reduceLeft(_ - _)
    val i2 = list.reduceRight(_ - _)
    println(i1)
    println(i2)
}



