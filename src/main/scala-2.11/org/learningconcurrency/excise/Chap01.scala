package org.learningconcurrency.excise


/**
  * Created by amoszhou on 16/1/27.
  */

class Chap01 {

}

object Chap01 extends App {

  def compose[A, B, C](g: B => C, f: A => B): A => C = {
    val h: A => C = a => g(f(a))
    h
  }

  def compose02[A, B, C](g: B => C, f: A => B): A => C = a => g(f(a))


  def fuse[A, B](a: Option[A], b: Option[B]): Option[(A, B)] = a.flatMap { v1 =>
    b.map { v2 =>
      (v1, v2)
    }
  }

  def fuse2[A, B](a: Option[A], b: Option[B]): Option[(A, B)] = {
    for (v1 <- a; v2 <- b) yield (v1, v2)
  }


  def check[T](xs: Seq[T])(pred: T => Boolean): Boolean = xs.forall(pred)
}


