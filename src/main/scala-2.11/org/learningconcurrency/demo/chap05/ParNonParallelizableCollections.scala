package org.learningconcurrency.demo.chap05

/**
  * Created by amos.zhou on 2016/2/29.
  */
object ParNonParallelizableCollections extends App {

  val list = List.fill(1000000)("")
  val vector = Vector.fill(1000000)("")

  log(s"list convert time is : ${timed(list.par)} ms")
  log(s"vector convert time is : ${timed(vector.par)} ms")

}
