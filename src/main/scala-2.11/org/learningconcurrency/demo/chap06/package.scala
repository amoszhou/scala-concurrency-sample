package org.learningconcurrency.demo

/**
  * Created by amos.zhou on 2016/3/2.
  */
package object chap06 {

  def log(msg: String): Unit = {
    println(s"${Thread.currentThread.getName} : $msg")
  }
}
