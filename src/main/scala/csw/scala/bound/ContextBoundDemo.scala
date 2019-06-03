package csw.scala.bound

class ContextBoundDemo[T: Ordering] {
    def select(f: T, s: T): T = {
        val ord: Ordering[T] = implicitly[Ordering[T]]
        if (ord.gt(f, s))
            f
        else
            s
    }
}

class Girl(val name: String, val age: Int, val face: Int)

object Context {

    implicit object OrderingGirl extends Ordering[Girl] {
        override def compare(x: Girl, y: Girl): Int = {
            if (x.face == x.face) {
                y.age - x.age
            } else {
                x.face - y.face
            }
        }
    }

}

object ContextBoundDemo extends App {

    import Context.OrderingGirl

    val cbd = new ContextBoundDemo[Girl]
    val g1 = new Girl("biaozi", 26, 120)
    val g2 = new Girl("erdiao", 24, 100)
    println(cbd.select(g1, g2).name)
}




