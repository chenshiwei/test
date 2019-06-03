package csw.scala.other

/**
  * 作用:
  *
  * @author chensw
  * @since 2018/8/28
  */
object AssinmentInternals {
    def main(args: Array[String]): Unit = {
        var a@b = 1000 //a是别名,b是个常量(a被绑定到b上),背后是模式匹配完成的
        b += 1 //a = 1000, b = 1001
        println("a = " + a + ", b = " + b)

        val (c, d) = (1000, 2000)
        //    val (e, F) = (1000, 2000) //大写的话F按常量匹配,需要定义才能使用,所以报错
        val Array(g, h) = Array(1000, 2000)

    }
}
