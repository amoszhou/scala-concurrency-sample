package org.learningconcurrency.demo.chap05


import scala.collection.parallel.ForkJoinTaskSupport
import scala.concurrent.forkjoin.ForkJoinPool
import scala.util.Random

/**
  * Created by amos.zhou on 2016/2/29.
  */
object ParConfig extends App {

  val fjpool = new ForkJoinPool(2)
  val customerTaskSupport = new ForkJoinTaskSupport(fjpool)
  val numbers = Random.shuffle(Vector.tabulate(5000000)(i => i))
  val parTime = timed {
    val parNumbers = numbers.par
    parNumbers.tasksupport = customerTaskSupport
    val n = parNumbers.max
    println(s"largest number $n")
  }
  log(s"Parallel time $parTime ms")
}
