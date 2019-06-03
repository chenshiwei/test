package csw.scala.test

object JavaConversionsTest {

    import java.util.ArrayList;

    def getList = {
        val list = new ArrayList[String]()
        list.add("摇摆少年梦")
        list.add("学途无忧网金牌讲师")
        list
    }


    def main(args: Array[String]) {
        val list = getList

        import scala.collection.JavaConversions._
        list.foreach(println)
        val str =
            s"""   i like it
wxd poi   
hgushj $list
 jasi ${list(0)} yuy
 hudh jid 
    """.stripMargin.trim.replace("\n", "")
        str.substring(4)
        println(str)
    }
}