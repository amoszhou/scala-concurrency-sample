package org.learningconcurrency.demo.chap06

import rx.lang.scala._

/**
  * Created by amos.zhou on 2016/3/2.
  */
object ObservablesItems extends App {

  val o = Observable.just("Pascal", "Java", "Scala")

  o.subscribe(name => log(s"learned the $name language"))
  o.subscribe(name => log(s"forgot the $name language"))
}
