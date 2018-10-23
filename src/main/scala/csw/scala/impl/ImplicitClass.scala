package csw.scala.impl

object Count {

  implicit class IntWithTimes(x: Int) {
    def times[A](f: => A): Unit = {
      def loop(c: Int): Unit = {
        if (c > 0) {
          f
          loop(c - 1)
        }
      }

      loop(x)
    }
  }

  implicit class Indexer[T](collection:Seq[T])(implicit index:Int)

  val IntWithTimes=10

}

import csw.scala.impl.Count._

object ImplicitClass extends App {
  10 times println(IntWithTimes)
}
