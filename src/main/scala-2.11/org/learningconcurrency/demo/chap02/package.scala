package org.learningconcurrency.demo

/**
  * Created by amoszhou on 16/1/27.
  */
package object chap02 {
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
