package org.learningconcurrency.demo.chap02

import org.learningconcurrency.demo.chap02.SynchronizedPool.Worker._

import scala.annotation.tailrec

/**
  * Created by amos.zhou on 2016/1/28.
  */
object ShutdownGraceful extends App {

  import scala.collection._

  private val tasks = mutable.Queue[() => Unit]()

  object Worker extends Thread {
    var terminated = false;

    def poll() = tasks.synchronized {
      while (tasks.isEmpty && !terminated) tasks.wait()
      if (!terminated)
        Some(tasks.dequeue())
      else
        None
    }

    @tailrec
    override def run() = poll() match {
      case Some(task) => task(); run()
      case None =>
    }

    def shutDown() = tasks.synchronized {
      terminated = true
      tasks.notify()
    }
  }


  Worker.start()


  def asynchronous(body: => Unit) =
    tasks.synchronized {
      tasks.enqueue(() => body)
      tasks.notify()
    }

  asynchronous {
    log("Hello ")
  }


  asynchronous {
    log("World!")
  }

  Thread.sleep(5000)

  Worker.shutDown()
}
