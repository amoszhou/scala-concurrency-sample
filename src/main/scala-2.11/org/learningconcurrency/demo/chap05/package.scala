package org.learningconcurrency.demo


/**
  * Created by amos.zhou on 2016/2/26.
  */
package object chap05 {

  @volatile var dummy: Any = _

  def timed[T](body: => T): Double = {
    val start = System.nanoTime()
    dummy = body
    val end = System.nanoTime()

    ((end - start) / 1000) / 1000.0
  }

  def log(msg: String): Unit = {
    println(s"${Thread.currentThread.getName} : $msg")
  }

}
