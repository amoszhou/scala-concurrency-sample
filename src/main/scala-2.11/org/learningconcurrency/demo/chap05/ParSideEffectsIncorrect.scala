package org.learningconcurrency.demo.chap05

import scala.collection.GenSet

/**
  * 多运行几次，发现结果不同，才能对比。
  * Created by amos.zhou on 2016/2/29.
  */
object ParSideEffectsIncorrect extends App {

  /**
    * a.count(x => b contains x)
    * @param a
    * @param b
    * @return
    */
  def intersectionSize(a: GenSet[Int], b: GenSet[Int]): Int = {
    var total = 0;
    for (x <- a) if (b contains x) total += 1
    total
  }

  val a = (0 until 1000).toSet
  val b = (0 until 1000 by 4).toSet
  val seqres = intersectionSize(a, b)
  val parres = intersectionSize(a.par, b.par)
  val partParRes = intersectionSize(a, b.par)
  log(s"Sequential result - $seqres")
  log(s"Parallel result - $parres")
  log(s"Parallel result - $partParRes")

}
