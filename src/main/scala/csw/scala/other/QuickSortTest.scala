package csw.scala.other

/**
  * 作用:
  *
  * @author chensw
  * @since 2018/9/20
  */
object QuickSortTest {
    def quickSort(list: List[Int]): List[Int] = {
        list match {
            case Nil => Nil
            case List() => List()
            case head :: tail =>
                val (left, right) = tail.partition(_ < head)
                quickSort(left) ::: head :: quickSort(right)
        }
    }

    def quickSort2(lst: List[Int]): List[Int] = {
        if (lst.isEmpty) lst
        else {
            val p = lst.head
            val (before, after) = lst.tail.partition(_ < p)
            quickSort(before) ::: p :: quickSort(after)
        }
    }

    def main(args: Array[String]) {
        val list = List(3, 12, 43, 23, 7, 1, 2, 0)
        println(quickSort2(list))
    }

}
