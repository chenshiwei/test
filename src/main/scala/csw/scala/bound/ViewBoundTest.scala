package csw.scala.bound

object ViewBoundTest extends App {
    //  val p = new Piar(1, 2)
    //  println(p.smaller)
    val s1 = new Student("DeleteTest")
    val s2 = new Student("B")

    val p = new Pair(s1, s2)
    val p1 = new Person("AA")
    println(p.reFirst(p1).second)
    //  println(Int <%< java.lang.Integer)
}

class Pair[T /*<% Comparable[T]*/ ](val first: T, val second: T) {
    //  def smaller: T = if (first.compareTo(second) < 0) first else second
    def reFirst[R >: T](newF: R) = new Pair(newF, second)
}

class Person(name: String)

class Student(name: String) extends Person(name)