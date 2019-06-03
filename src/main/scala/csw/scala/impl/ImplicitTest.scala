package csw.scala.impl

class A(val name: String)

class RichA(val a: A) {
    def read() = println("cao" + a.name)
}

object A {
    implicit def a2RichA(a: A) = new RichA(a)
}

object CC {
    implicit val default: String = "cao"
}

object DD {
    implicit val default: String = "dao"
}

object SS {
    def print(s: String)(implicit l: String) = println(s + l)
}

object ImplicitTest extends App {

    import DD.default

    println("d")
    new A("jack").read()
    SS.print("jim")
}