package org.learningconcurrency.demo

import scala.concurrent.ExecutionContext

/**
  * Created by amos.zhou on 2016/2/1.
  */
package object chap03 {

  def execute(body: => Unit) = {
    ExecutionContext.global.execute(new Runnable {
      override def run(): Unit = body
    })
  }

  def log(msg: String): Unit = {
    println(s"${Thread.currentThread.getName} : $msg")
  }
}
