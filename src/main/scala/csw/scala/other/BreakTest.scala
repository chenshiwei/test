package csw.scala.other

import scala.util.control.Breaks

object BreakTest {
    def main(args: Array[String]) {
        val numList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        Breaks.breakable {
            for (a <- numList) {
                println("Value of a: " + a)
                if (a == 4) {
                    Breaks.break
                }
            }
        }
        println("After the loop")
        val numList1 = List(1, 2, 3, 4, 5)
        val numList2 = List(11, 12, 13)

        val outer = new Breaks
        val inner = new Breaks

        outer.breakable {
            for (a <- numList1) {
                println("Value of a: " + a)
                inner.breakable {
                    for (b <- numList2) {
                        println("Value of b: " + b)
                        if (b == 12) {
                            inner.break
                        }
                    }
                } // 内嵌循环中断
                if (a == 3) {
                    outer.break
                }
            }
        } // 外部循环中断
    }
}