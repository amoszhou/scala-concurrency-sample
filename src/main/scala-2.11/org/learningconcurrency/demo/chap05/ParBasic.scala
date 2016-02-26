package org.learningconcurrency.demo.chap05

import scala.util.Random

/**
  * Created by amos.zhou on 2016/2/26.
  */
object ParBasic extends App {

  val numbers = Random.shuffle(Vector.tabulate(50000000)(i => i))

  val seqTime = timed {
    numbers.max
  }


  log(s"seq  time  $seqTime ms")

  val parTime = timed {
    numbers.par.max
  }

  log(s"parallel Time  $parTime ms")
}
