package org.learningconcurrency.demo.chap02

/**
  * Created by amos.zhou on 2016/1/28.
  */
object SynchronizedGuardedBlocks extends App {

  val lock = new AnyRef

  var message: Option[String] = None

  val greeter = thread {
    lock.synchronized {
      while (message == None) lock.wait()
      log(message.get)
    }
  }


  lock.synchronized {
    message = Some("Hello!")
    lock.notify()
  }

  greeter.join()
}
