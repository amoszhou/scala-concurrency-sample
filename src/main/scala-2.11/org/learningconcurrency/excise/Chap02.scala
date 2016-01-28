package org.learningconcurrency.excise

/**
  * Created by amos.zhou on 2016/1/28.
  */
class Chap02 {

  def parallel[A, B](a: => A, b: => B): (A, B) = {
    val t1 = thread {
      a
    }
    val t2 = thread {
      b
    }
    t1.join()
    t2.join()
    (a, b)
  }


}
