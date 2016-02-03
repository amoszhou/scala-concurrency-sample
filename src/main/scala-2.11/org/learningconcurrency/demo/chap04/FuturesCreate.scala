package org.learningconcurrency.demo.chap04

import scala.concurrent._
import ExecutionContext.Implicits.global

/**
  * Created by amos.zhou on 2016/2/2.
  */
object FuturesCreate extends App {

  Future {
    log("The future is here")
  }
  log("the future is coming")
  Thread.sleep(1000)
}
