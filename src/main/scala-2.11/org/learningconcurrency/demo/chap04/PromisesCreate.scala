package org.learningconcurrency.demo.chap04

import scala.concurrent.Promise
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by amos.zhou on 2016/2/24.
  */
object PromisesCreate extends App {

  val p = Promise[String]
  val q = Promise[String]

  p.future foreach {
    case x => log(s"p successed with '$x'")
  }

  Thread.sleep(1000)
  log("sleep over......")

  p.success("assigned")

  q.failure(new Exception("not kept"))

  q.future.failed.foreach {
    case t => log(s"q failed with $t")
  }

  Thread.sleep(1000)
}
