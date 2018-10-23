package csw.scala.ga

import scala.collection.mutable

import scala.util.control.Breaks._

/**
  * 作用:
  *
  * @author chensw
  * @since 2018/8/28
  */
class Population(s: Int) {

  private val size: Int = s
//  private val averageFitness: Double = 0
  private val relativeFitness = new Array[Double](s)
  private val chromeLen: Int = 30
  var bestAgent: Agent = _
  var worstAgent: Agent = _
  var currentBest: Agent = _
  private var generation: Int = 0
  private var pop = new mutable.ArrayBuffer[Agent](s)
  private var worstIndex = 0

  //初始化种群
  def initPop(): Unit = {
    for (_ <- 0 until size) pop += new DeJongAgent(chromeLen)
    for (i <- 0 until size) {
      pop(i).generateAgent()
    }
    currentBest = pop(0)
    findBestAndWorstAgent()
  }

  //找出适应度最大的个体
  def findBestAndWorstAgent(): Unit = {
    bestAgent = pop(0)
    worstAgent = pop(0)
    for (i <- 1 until size) {
      if (pop(i).getfitness > bestAgent.getfitness) {
        bestAgent = pop(i)
      }
      if (pop(i).getfitness < worstAgent.getfitness) {
        worstAgent = pop(i)
        worstIndex = i
      }
    }
    if (bestAgent.getfitness > currentBest.getfitness) {
      currentBest = bestAgent.clone
    }

  }

  //进化
  def evolve(): Unit = {
    select()
    crossover()
    mutate()
    evaluate()
  }

  def select(): Unit = {
    val roulettewheel = new Array[Double](size)
    var childPop = new mutable.ArrayBuffer[Agent](size)
    calRelativeFitness()

    //产生赌盘

    roulettewheel(0) = relativeFitness(0)
    for (i <- 1 until size - 1) roulettewheel(i) = relativeFitness(i) + roulettewheel(i - 1)
    roulettewheel(size - 1) = 1

    //进行赌盘选择
    for (p <- pop) {
      val rnd = Math.random()
      breakable { //scala跳出循环
        for (i <- 0 until size) {
          if (rnd < roulettewheel(i)) {
            childPop += p
            break
          }
        }
      }
    }
    pop = childPop
  }

  //计算相对适应度
  def calRelativeFitness(): Unit = {
    for (i <- 0 until size) relativeFitness(i) = pop(i).getfitness
  }

  //交叉操作：单点交叉
  def crossover(): Unit = {
    for (i <- 0 until(size,2)) {
      //两两配对
      var rnd = rand(i,size)
      if (rnd != i) exchange(pop,i,rnd)
      rnd = rand(i,size)
      if (rnd != i + 1) exchange(pop,i + 1,rnd)

      //交叉
      if (Math.random() < GlobalParameter.crossoverRate) cross(i)
    }
  }

  //执行交叉操作
  def cross(i: Int): Unit = {
    val rnd = rand(0,chromeLen - 1)
    pop(i).setChrom(rnd + 1,chromeLen - 1,pop(i + 1).getChrom(rnd + 1,chromeLen - 1))
    pop(i + 1).setChrom(rnd + 1,chromeLen - 1,pop(i).getChrom(rnd + 1,chromeLen - 1))
  }

  //产生区间内的随机数
  def rand(start: Int,end: Int): Int = {
    (Math.random() * (end - start) + start).toInt
  }

  //交换
  def exchange(pop: mutable.ArrayBuffer[Agent],src: Int,dest: Int) {
    val agent = pop(src)
    pop(src) = pop(dest)
    pop(dest) = agent
  }

  //变异操作
  def mutate(): Unit = {
    for (p <- pop) {
      for (j <- 0 until chromeLen) {
        if (Math.random() < GlobalParameter.mutateRate) p.mutateSingleBit(j)
      }
    }
  }

  //计算目标函数值，适应度，找出最优个体
  def evaluate(): Unit = {
    //同步目标函数值和适应度
    for (p <- pop) {
      p.calFitness()
      p.calTargetValue()
    }
    //使用最优保存策略保存最优个体
    findBestAndWorstAgent()
    pop(worstIndex) = currentBest.clone
    generation += 1
  }

  //判断进化是否完成
  def isEvolutionDone: Boolean = generation >= GlobalParameter.maxGeneration

  //计算平均适应度
  def calAverageFitness: Double = caltotalFitness / size

  //计算总的适应度
  def caltotalFitness: Double = {
    var total: Double = 0
    for (p <- pop) total += p.getfitness
    total
  }

  def generation_(newge: Int): Unit = {
    generation = newge
  }

  def getGeneration: Int = generation

  override def toString: String = pop.mkString("\n")

}
