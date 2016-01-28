package org.learningconcurrency.demo.chap02

/**
  * Created by amos.zhou on 2016/1/28.
  */
object SynchronizedPool extends App {

  import scala.collection._

  private val tasks = mutable.Queue[() => Unit]()

  object Worker extends Thread {
    setDaemon(true)

    def poll() = tasks.synchronized {
      while (tasks.isEmpty) tasks.wait()
      log("Get Lock")
      tasks.dequeue()
    }

    override def run() = while (true) {
      val task = poll()
      task()
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


  log("Lock still in Main Thread")

  asynchronous {
    log("World!")
  }
  Thread.sleep(500)

}
