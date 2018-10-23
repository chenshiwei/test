package csw.scala.impl

import java.io.File

import csw.scala.path

import scala.io.Source

object ImplicitFunction extends App {

  //File类的对象并不存在read方法，此时便会发生隐式转换
  //将File类转换成RichFile
  val f = new File(s"$path/src/main/resources/readTest").read

  implicit def double2Int(x: Double): Int = x.toInt

  var x: Int = 3.5

  //隐式函数将java.io.File隐式转换为RichFile类
  implicit def file2RichFile(file: File): RichFile = new RichFile(file)
  var a: Long = 10

  println(f)
  var b: Double = 100.99

  //RichFile类中定义了Read方法
  class RichFile(val file: File) {
    def read: String = Source.fromFile(file).getLines().mkString("\n")
  }

  //  b = 100
  //  b = a

  //a=b
  implicit def d2i(x: Double): Long = math.round(x)

  a = b
  println(a)
}