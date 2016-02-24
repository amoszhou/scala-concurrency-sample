package org.learningconcurrency.demo.chap04

import scala.concurrent.{Promise, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.control.NonFatal

/**
  * Created by amos.zhou on 2016/2/24.
  */
object PromisesCustomAsync extends App {


  def myFuture[T](b: => T): Future[T] = {
    val p = Promise[T]
    global.execute(new Runnable {
      override def run(): Unit = try {
        p.success(b)
      } catch {
        case NonFatal(e) => p.failure(e)
      }
    })
    p.future
  }


  val f = myFuture {
    "naa" + "na" * 8 + " Katamari Damacy!"
  }
  f foreach { case text => log(text) }

  Thread.sleep(3000)

}
