package org.learningconcurrency.demo.chap03

/**
  * Created by amos.zhou on 2016/2/1.
  */
object ExecutionContextSleep extends App {

  for (i <- 0 until 32) execute {
    Thread.sleep(2000)
    log(s"Task $i  is  completed!")
  }

  Thread.sleep(10000)
}
