package org.learningconcurrency.demo.chap06

import rx.lang.scala.Observable

/**
  * Created by amos.zhou on 2016/3/2.
  */
object ObservablesExceptions extends App {

  val exc = new RuntimeException
  val o = Observable.just(1, 2) ++ Observable.error(exc)
  o.subscribe(
    x => log(s"number $x"),
    t => log(s"an error occurred: $t ")
  )

}
