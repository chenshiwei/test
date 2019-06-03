package csw.scala.test

import java.util.concurrent.TimeUnit

object CapacityAnalysisTest extends App {


    val array = 20.to(60).map(_.toDouble).toArray
    println(capacityAnalysis(array, caGranularity = TimeUnit.DAYS.toMillis(1)) / TimeUnit.DAYS.toMillis(1).toDouble)


    /**
      * 容量分析算法——逆向二次平滑指数法
      *
      * @param array         :已按时间排序，间隔基本上是固定的
      * @param caAlpha       :二次平滑指数法的平滑系数
      * @param caTendencyUp  :指标是否向上趋势
      * @param caGranularity :历史数据的粒度
      * @param caThreshold   :容量阈值
      * @return :容量超出阈值的时间
      */
    private def capacityAnalysis(array: Array[Double], caAlpha: Double = 0.5, caTendencyUp: Boolean = true,
                                 caGranularity: Long = TimeUnit.HOURS.toMillis(6), caThreshold: Double = 100.0): Long = {
        if (array.length < 5 || caAlpha <= 0 || caAlpha >= 1) {
            return Long.MaxValue
        }
        var lastIndex: Double = array(0)
        var lastSecIndex: Double = array(0)
        for (data <- array) {
            lastIndex = caAlpha * data + (1 - caAlpha) * lastIndex
            lastSecIndex = caAlpha * lastIndex + (1 - caAlpha) * lastSecIndex
        }
        val a: Double = 2 * lastIndex - lastSecIndex
        val b: Double = (caAlpha / (1 - caAlpha)) * (lastIndex - lastSecIndex)
        if (caTendencyUp == (a >= caThreshold)) return 0L
        if (caTendencyUp == (b < 0) || b == 0) return Long.MaxValue
        (caGranularity * (caThreshold - a) / b).toLong
    }
}
