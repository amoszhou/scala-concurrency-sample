package org.learningconcurrency.demo.chap02

/**
  * Created by amoszhou on 16/1/27.
  */
object ThreadsCommunicate extends App {

  var result: String = null

  val t = thread {
    result = "\nTitle\n" + "=" * 5
  }
  t.join()
  log(result)
}
