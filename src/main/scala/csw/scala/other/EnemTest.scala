package csw.scala.other

object EnemTest extends App {
    def ignoreParam: String => String = (url: String) => url.stripPrefix("\\?")

    println("http:gfuhuhcdfs?huvhfw".split("\\?")(0))

    object PageLevel extends Enumeration {
        type PageLevel = Value
        val entrance = Value(1)
        val entrance2, guide, guide2, before_goods, goodsPage, shoppingCart, userPay = Value
    }

}


