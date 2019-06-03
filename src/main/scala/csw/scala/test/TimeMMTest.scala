package csw.scala.test

import java.util.Calendar
import java.util.concurrent.TimeUnit

object TimeMMTest extends App {
    val SECOND: Long = TimeUnit.SECONDS.toMillis(1)
    val MINUTE: Long = TimeUnit.MINUTES.toMillis(1)
    val HOUR: Long = TimeUnit.HOURS.toMillis(1)
    val DAY: Long = TimeUnit.DAYS.toMillis(1)
    val TIME_ZONE_OFFSET: Long = Calendar.getInstance().getTimeZone.getOffset(0)
    val GTM_8_OFFSET: Long = TimeUnit.HOURS.toMillis(8)

    val t = System.currentTimeMillis()
    println(SECOND, MINUTE, HOUR, DAY, TIME_ZONE_OFFSET, GTM_8_OFFSET)

    println(System.currentTimeMillis() - t)
}
