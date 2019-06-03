package csw.scala.impl

object ImplicitParam {

    class M_A[T]

    class M_B[T]

    def main(args: Array[String]): Unit = {
        implicit val a = new M_A[Int]
        implicit val b = new M_B[Int]

        def foo[T: M_A : M_B](i: T) = println(a)

        foo(3)

        def rock[T](i: T)(implicit ev: T <:< java.io.Serializable) = println(ev)

        rock("16")
        implicit val as: Int = 2

        def add(x: Long)(implicit y: Int): Long = x + y

        println(add(1))


        def addTest(x: Int, y: Int)(implicit adder: Adder[Int]): Int = {
            adder.add(x, y)
        }

        implicit val ae = new Adder[Int] {
            override def add(x: Int, y: Int): Int = x + 2 * y
        }

        trait Adder[T] {
            def add(x: T, y: T): T
        }

        println(addTest(5, 4))

        def bigger[T](a: T, b: T)(implicit ordered: T => Ordered[T])

        = {
            println(ordered)
            if (ordered(a) > b) a else b
        }

        println(bigger(3, 4))
        println(bigger("yy", "xx"))
    }
}