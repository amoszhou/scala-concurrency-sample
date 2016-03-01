package org.learningconcurrency.demo.chap05

import scala.collection.GenIterable

/**
  * Created by amos.zhou on 2016/3/1.
  */
object ParNonCommutativeOperator extends App {


  val doc = scala.collection.mutable.ArrayBuffer.tabulate(20)(i => s"Page $i,")

  def test(doc: GenIterable[String]) {
    val seqText = doc.seq.reduceLeft(_ + _)
    val parText = doc.par.reduce(_ + _)
    log(s" the seqTet is  $seqText \n")
    log(s" the parText is $parText \n")
  }

  test(doc)
  test(doc.toSet)
}
