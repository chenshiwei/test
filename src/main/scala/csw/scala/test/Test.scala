package csw.scala.test

import java.util.Date

object Test extends App {


  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }

  println(toInt("23"))
  println(toInt("23").get)
  println(toInt("abc"))
  //    println(toInt("abc").get)  ---->报错误，因为没有返回值
  val xx = if (toInt("foo").isDefined) toInt("foo") else 0
  println("处理结果："+xx)

  val a: Seq[Any] = List(1,"d",(4,5),new Date())
  println(a(2))


}



