package csw.scala.bound

class ViewBoundDemo[T <% Ordered[T]] {
  def select(f: T, s: T): T = {
    if (f > s) f else s
  }
}


object Context1 {
  implicit val selectGirl = (g: Girl) => new Ordered[Girl] {
    override def compare(that: Girl): Int = {
      if (g.face == that.face) {
        that.age - g.age
      } else {
        g.face - that.face
      }
    }
  }
}

object ViewBoundDemo extends App {
  import Context1.selectGirl
  val viewBoundDemo = new ViewBoundDemo[Girl]
  val g1 = new Girl("biaozi", 26, 120)
  val g2 = new Girl("erdiao", 24, 100)
  println(viewBoundDemo.select(g1, g2).name)
}




