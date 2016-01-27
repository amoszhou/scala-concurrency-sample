package org.learningconcurrency.demo.chap02

/**
  * Created by amoszhou on 16/1/27.
  */
object ThreadMain extends App {

  val t = Thread.currentThread();
  val name = t.getName
  println(s"I am the thread $name")

}
