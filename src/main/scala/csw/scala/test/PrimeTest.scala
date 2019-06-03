package csw.scala.test

object PrimeTest extends App {

    val t = System.currentTimeMillis()

    def isPrime(n: Int): Boolean =
        if (n == 2 || n == 3) true
        else if (n % 2 == 0) false
        else 3.to(math.ceil(math.sqrt(n)).toInt).toArray.filter(_ % 2 != 0).map(n % _ != 0).reduce(_ && _)

    def getnth(n: Int): Int =
        if (n == 1) 2
        else if (n == 2) 3 else {
            var p = 3
            var x = 2
            while (x < n) {
                p += 2
                if (isPrime(p)) x += 1
            }
            p
        }

    //  var tmp = 2
    //  2.to(1000000).toArray.filter(isPrime).map(p => {
    //    val r = p - tmp
    //    tmp = p
    //    r
    //  }).foreach(println)
    println(getnth(10001))
    println(System.currentTimeMillis() - t)
}
