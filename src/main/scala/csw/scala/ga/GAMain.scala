package csw.scala.ga

/**
  * 作用:
  *
  * @author chensw
  * @since 2018/8/28
  */

import java.io.PrintWriter

object GAMain {

    def main(args: Array[String]): Unit = {
        val out = new PrintWriter("c:\\scala.txt")
        val pop = new Population(GlobalParameter.populationSize)
        pop.initPop()
        out.println("初始种群:\n" + pop)
        while (!pop.isEvolutionDone) {
            pop.evolve()
            out.println("第" + pop.getGeneration + "代Best:" + pop.bestAgent)
            //  println("第" + pop.getGeneration+ "代Best:" + pop.bestAgent)
            out.println("第" + pop.getGeneration + "代current:" + pop.currentBest)
            //   println("第" + pop.getGeneration+ "代current:" + pop.currentBest)
            out.println()
        }
        out.println()
        out.println("第" + pop.getGeneration + "代群体:\n" + pop)
        out.close()
    }


}
