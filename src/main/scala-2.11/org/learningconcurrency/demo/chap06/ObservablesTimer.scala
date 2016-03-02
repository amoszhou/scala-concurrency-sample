package org.learningconcurrency.demo.chap06

import rx.lang.scala.Observable

import scala.concurrent.duration.Duration


/**
  * Created by amos.zhou on 2016/3/2.
  */
object ObservablesTimer extends App {

  val o = Observable.timer(Duration(1, "second"))
  o.subscribe(_ => log("Timeout!"))
  o.subscribe(_ => log("Another timeout!"))
  Thread.sleep(2000)

}
