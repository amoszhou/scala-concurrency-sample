package org

/**
  * Created by amoszhou on 16/1/27.
  */
package object learningconcurrency {
  def log(msg: String): Unit = {
    println(s"${Thread.currentThread.getName} : $msg")
  }
}
