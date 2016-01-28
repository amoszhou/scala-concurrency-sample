package org.learningconcurrency

/**
  * Created by amos.zhou on 2016/1/28.
  */
package object excise {
  def log(msg: String): Unit = {
    println(s"${Thread.currentThread.getName} : $msg")
  }

  def thread(body: => Unit): Thread = {
    val t = new Thread {
      override def run() = body
    }
    t.start()
    t
  }
}
