package csw.java.util

case class Csw ( age :Int)
object Csw extends App {
  val csw = new Csw(1)
//  csw.age = 24
  println(csw.age)
}