package org.learningconcurrency.demo.chap02

/**
  * Created by amoszhou on 16/1/27.
  */
object ThreadsSleep extends App {

  val t = thread {
    Thread.sleep(1000)
    log("New thread running ")
    Thread.sleep(1000)
    log("Still running")
    Thread.sleep(1000)
    log("Completed")
  }

  t.join()
  log("New Thread joined.")



}
