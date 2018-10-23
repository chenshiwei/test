package csw.scala.other

import java.util.Calendar

object CaseMatchTest extends App {
  val TIME_ZONE_OFFSET: Long = Calendar.getInstance().getTimeZone.getOffset(0)
  println(TIME_ZONE_OFFSET)
  println(List(1,2,3,4,5,6).reduceRight(_ - _))
  val a = 4
  val b = a match {
    case 1 => "ds"
    case 2 => "sd"
    case p => s"$p/sjk"
  }
  println(b)
  val intToInt = Map(1 -> 2,3 -> 4)
  println(intToInt.getOrElse(2,444))

}