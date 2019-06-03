package csw.scala.impl

object ImplicitMethodTest extends App {

    class TestA {
        override def toString = "This is TestA"

        def printA = println(this)
    }

    class TestB {
        override def toString = "This is TestB"

        def printB(x: TestC) = println(x)
    }

    class TestC {
        override def toString = "This is TestC"

        def printC = println(this)
    }

    implicit def A2B(x: TestA) = {
        println("A 2 B")
        new TestB
    }

    implicit def B2C(x: TestB) = {
        println("B 2 C")
        new TestC
    }

    val a = new TestA
    a.printB(new TestB)
}