package csw.scala.impl

object ImplicitAllTest extends App {

    implicit class Dog(val name: String) {
        def bark = println(s"$name is barking")
    }

    implicit def double2Int(x: Double) = x.toInt

    var x: Int = 3.5
    "cao".bark
    implicit val as: Int = 2

    def add(x: Long)(implicit y: Int): Long = x + y

    println(add(1))
}