package csw.scala.other

import scala.collection.mutable.SortedSet
object QueueTest extends App {
  val queue = SortedSet[Long](1L, 2L)
  //  val queue = Queue[Long](1L, 2L)
  println()
  queue.+=(11L)
  queue.+=(11L)
  queue.+=(13L)
  queue.+=(14L)
  println(queue)

  queue += 15L

  queue ++= List(6L, 7L)

  println(queue.drop(1))
  println(queue.head)
  queue -= queue.head
  println(queue.head)
  println(queue.tail)
  println(Map(1->2,2->3).getOrElse(3, 0))

}