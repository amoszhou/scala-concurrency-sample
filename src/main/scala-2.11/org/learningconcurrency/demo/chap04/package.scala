package org.learningconcurrency.demo

/**
  * Created by amos.zhou on 2016/2/2.
  */
package object chap04 {
  def log(msg: String): Unit = {
    println(s"${Thread.currentThread.getName} : $msg")
  }
}
