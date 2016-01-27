package org.learningconcurrency.demo.chap02

/**
  * Created by amoszhou on 16/1/27.
  */
object ThreadsCreation extends App {

  class MyThread extends Thread {
    override def run(): Unit = {
      println("New Thread running")
    }
  }

  val t = new MyThread();
  t.start()
  t.join()
  println("New thread Joined.")


}
