package csw.scala.bound

class UpperBoundTest[T <: Comparable[T]] {
  def select(first: T, second: T): T = {
    if (first.compareTo(second) > 0) first else second
  }
}

object UpperBoundTest {
  def main(args: Array[String]): Unit = {
    val u = new UpperBoundTest[MissRight]
    val m1 = new MissRight("biaozi", 120)
    val m2 = new MissRight("erdiao", 999)
    println(u.select(m1, m2).name)
  }
}

class MissRight(val name: String, val face: Int) extends Comparable[MissRight] {
  override def compareTo(o: MissRight): Int = {
    this.face - o.face
  }
}
